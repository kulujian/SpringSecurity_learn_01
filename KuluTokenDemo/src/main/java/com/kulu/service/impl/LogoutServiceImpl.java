package com.kulu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kulu.domain.LoginUser;
import com.kulu.domain.ResponseResult;
import com.kulu.service.LogoutService;
import com.kulu.utils.RedisCache;

@Service
public class LogoutServiceImpl implements LogoutService{

	@Autowired
	private RedisCache redisCache;
	
	@Override
	public ResponseResult logout() {
		// 獲取【SecurityContextHolder】中的用戶id
		UsernamePasswordAuthenticationToken authentication = 
				(UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		LoginUser loginUser = (LoginUser) authentication.getPrincipal();
		Long userid = loginUser.getUser().getId();
		// 刪除【redis】中的值
		redisCache.deleteObject("login:" + userid);
		
		return new ResponseResult<>(200, "注銷成功");
	}
}
