package com.kulu.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kulu.domain.LoginUser;
import com.kulu.utils.JwtUtil;
import com.kulu.utils.RedisCache;

import io.jsonwebtoken.Claims;

/*
 * 自定義過濾器時有兩種選擇：實作一個介面(Filter)、繼承一個類(OncePerRequestFilter)
 * JavaWeb製作時通常會選擇【實作一個介面(Filter)】
 * 但是在這裡最好不要選擇實作介面(Filter)，選擇繼承一個類(OncePerRequestFilter)
 * 原因是默認的過濾器介面(Filter)在不同的【Servelt】版本當中有存在一定的問題
 * 導致一個請求過來過濾器會被調用多次。
 * 所以我們可以使用【SpringFramework】提供的實現類，我們只要繼承這個實現類可以了。
 * 由實現類的名可以看出(OncePerRequestFilter)，它保證我們的一個請求只會經過這個過濾器一次。
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{
	
	// 提取容器內【RedisCache】
	@Autowired
	private RedisCache rediscache;
	
	/*
	 * 繼承實現類之後，重寫實現類方法
	 * 實現類的用法與實作【Filer】介面過濾器的用法也是一樣的
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 獲取 token (如果是登入的狀態就必須在請求頭當中攜帶token，所以我們就可以在請求頭中獲取)
		String token = request.getHeader("token");
		// StringUtils.hasLength() boolean (""、null:false)
		if(!StringUtils.hasLength(token)) {
			// 沒 token 放行，由後面filter處理異常
			filterChain.doFilter(request, response);
			// 必免響應之後再接續後面代碼執行，因此加上return
			return;
		}
		// 解析 token 獲取其中的userid
		String userid;
		try {
			Claims claims = JwtUtil.parseJWT(token);
			userid = claims.getSubject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("token非法");
		}
		// 從 redis 獲取用戶信息
		String redisKey = "login:" + userid;
		// getCacheObject(String redisKey)，是經過封裝指定方法泛型，可以直接指定返回值的類型
		// 它會根據調用類型來進行推測。
		LoginUser loginUser = rediscache.getCacheObject(redisKey);
		// 需要進行判斷，因為有可能存在【redis】內不存在用戶信息的
		if(Objects.isNull(loginUser)) {
			throw new RuntimeException("用戶未登入");
		}
		// 存入 SecurityContextHolder
			// 2.找尋【Authentication】的實現類，創建一個對應的實現類物件並把【loginUser】封裝進去
			//	 使用三個參數進行封裝，第三個參數代表為：是否為已認證狀態
			// TODO 獲取權限信息封裝到 Authentication 中 (還沒做)
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
			// 1.設定【authentication】所需要的傳入參數為【authentication】，所以要將loginUser進行封裝
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		
		// 放行
		 filterChain.doFilter(request, response);
	}
}
