package com.kulu.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kulu.domain.LoginUser;
import com.kulu.domain.ResponseResult;
import com.kulu.domain.User;
import com.kulu.service.LoginService;
import com.kulu.utils.JwtUtil;
import com.kulu.utils.RedisCache;

@Service
public class LoginSerivceImpl implements LoginService{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired // 此功具類未使用【靜態方法】，但使用【@Component】注入，因此使用【@Autowired】提取
	private RedisCache redisCache;
	
	@Override
	public ResponseResult login(User user) {
		// 獲取【AuthenticationManager】的一個認證方法【authenticate】進行用戶認證
		// 需要在SecurityConfig 先做重寫注入【AuthenticationManagerBean】
		// 這樣上面才可以【@Autowired】提取已注入的方法
		// 2.找尋【Authentication】的實現類，創建一個對應的實現類物件並把【用戶名】【密碼】封裝進去
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
		// 1.發現使用【AuthenticationManager】【authenticate】方法認證，需要傳入【Authentication】物件作為參數
		Authentication authenticate = authenticationManager.authenticate(authenticationToken);
		
		// 如果認證沒通過，給出對應的提示
		// 利用DeBug模式設置斷點，確認如何獲取【authenticate】內User信息
		if(Objects.isNull(authenticate)) {
			throw new RuntimeException("登入失敗");
		}
		// 如果認證通過，使用【userid】生成一個【JWT】，【JWT】存入【ResponseResult】返回
		// 獲取的信息是物件類型(Object)，需要強轉為LoginUser類型才能返回
		LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

		// 通過就能夠獲取ID，但因為型別所以使用【toString】轉換。
		String userid = loginUser.getUser().getId().toString();

		String jwt = JwtUtil.createJWT(userid);

		// 設置傳送格式 token:jwt
		Map<String, String> map = new HashMap<>();
		map.put("token", jwt);
		
		// 把完整的用戶信息存入【rebis】，【userid】作成【key】
		redisCache.setCacheObject("login:" + userid, loginUser);

		return new ResponseResult(200, "登入成功", map);
	}
}
