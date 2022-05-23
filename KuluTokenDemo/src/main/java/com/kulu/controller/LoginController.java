package com.kulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulu.domain.ResponseResult;
import com.kulu.domain.User;
import com.kulu.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(path = "/user/login")
	public ResponseResult login(@RequestBody User user) {
		// 登入
		
		return loginService.login(user);
	}
}
