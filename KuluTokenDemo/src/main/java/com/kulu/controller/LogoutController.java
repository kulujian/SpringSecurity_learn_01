package com.kulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulu.domain.ResponseResult;
import com.kulu.service.LogoutService;

@RestController
public class LogoutController {

	@Autowired
	private LogoutService logoutService;
	
	@RequestMapping(path = "/user/logout")
	public ResponseResult loginout() {
		// 登出
		
		return logoutService.logout();
	}
}
