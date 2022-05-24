package com.kulu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kulu.domain.LoginUser;
import com.kulu.domain.User;
import com.kulu.mapper.MenuMapper;
import com.kulu.mapper.UserMapper;




@Service
public class UserDetailsServiceImpl implements UserDetailsService { // 【Details】細節
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenuMapper menuMapper;

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
//		寫入權限信息(練習題，所以直接寫死)
//			List<String> list = new ArrayList<>(Arrays.asList("test", "admin"));
//		用【uesrid】查詢該用戶【perms】(權限信息)
		List<String> list = menuMapper.selectPermsByUserid(user.getId());
		
		// 把數據封裝成【UserDetails】物件返回
		return new LoginUser(user, list);
	}	
}
