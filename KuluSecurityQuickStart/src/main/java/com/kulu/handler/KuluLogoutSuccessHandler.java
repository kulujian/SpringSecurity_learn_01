package com.kulu.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 自定義類
 * 製作登出成功後調用下面方法，完成登出後處理
 * 
 * @author user
 */
@Component
public class KuluLogoutSuccessHandler implements LogoutSuccessHandler{

	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("登出成功！");
	}

}
