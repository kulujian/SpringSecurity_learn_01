package com.kulu.expression;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.kulu.domain.LoginUser;
/**
 * 自定義類
 * 1. 獲取當前用戶權限集合
 * 2. 判斷集合中是否存在訪問端口所標識的權限
 * 
 * @author user
 */
@Component("ex") //@Component 加上名字=為注入容器的BEAN加上名字，未來方便以【SpEL】(Spring表達式語言)指定調用。
public class KuluExpressionRoot {

	public boolean hasAuthority(String authority) {
		// 獲取當前用戶的權限
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LoginUser loginUser = (LoginUser) authentication.getPrincipal();
		List<String> permissions = loginUser.getPermissions();	
		
		// 判斷用戶權限集合中是否存在authority
		return permissions.contains(authority);
	}
}
