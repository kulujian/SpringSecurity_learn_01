package com.kulu.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.kulu.domain.ResponseResult;
import com.kulu.utils.WebUtils;

/**
 * 認證過程出現異常
 * 
 * @author user
 */

@Component // 注入容器
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用戶認證失敗請重新登入");
		String json = JSON.toJSONString(result);
		// 處理異常
		WebUtils.renderString(response, json);
		
	}
}
