package com.kulu.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kulu.domain.LoginUser;
import com.kulu.domain.User;
import com.kulu.mapper.UserMapper;




@Service
public class UserDetailsServiceImpl implements UserDetailsService { // 【Details】細節
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 根據用戶名詢用戶信息
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(User::getUserName, username);
		User user = userMapper.selectOne(queryWrapper);
		// 如果查詢不到數據就通過拋出異常來給出提示
		if(Objects.isNull(user)) {
			throw new RuntimeException("用戶名或者密碼錯誤");
		}
		// TODO 查詢對應的權限信息
		
		// 把數據封裝成【UserDetails】物件返回
		return new LoginUser(user);
	}	
}
