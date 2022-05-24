package com.kulu.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.kulu.domain.ResponseResult;
import com.kulu.utils.WebUtils;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "您的授權不足");
		String json = JSON.toJSONString(result);
		// 處理異常
		WebUtils.renderString(response, json);
		
	}
}
