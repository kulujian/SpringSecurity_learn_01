package com.kulu.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.kulu.domain.ResponseResult;
import com.kulu.domain.User;
import com.kulu.service.LoginService;

@Service
public class LoginSerivceImpl implements LoginService{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public ResponseResult login(User user) {
		// 獲取【AuthenticationManager】的一個認證方法【authenticate】進行用戶認證
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(user.getUserType(), user.getPassword());
		Authentication authenticate = authenticationManager.authenticate(authenticationToken);
		// 如果認證沒通過，給出對應的提示
		if(Objects.isNull(authenticate)) {
			throw new RuntimeException("登入失敗");
		}
		// 如果認證通過，使用【userid】生成一個【JWT】，【JWT】存入【ResponseResult】返回
		
		// 把完整的用戶信息存入【rebis】，【userid】作成【key】
		return null;
	}

}
