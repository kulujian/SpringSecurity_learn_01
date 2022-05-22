package com.kulu.service;

import com.kulu.domain.ResponseResult;
import com.kulu.domain.User;

public interface LoginService {

	ResponseResult login(User user);

	ResponseResult logout();

}
