package com.kulu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private AuthenticationFailureHandler failureHandler;
	
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	/*
	 * 因為重寫了【configure(HttpSecurity)】成法，因此原本方法中設定的【任意請求】
	 * 都要經過認證才允許訪問的配置被覆蓋掉了，所以必需自行加入。
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			// 認證成功處理器
			.successHandler(successHandler)
			// 認證失敗處理器
			.failureHandler(failureHandler);
		
		http.logout()
			// 配置注銷成功處理器
			.logoutSuccessHandler(logoutSuccessHandler);
		
		
		//  重新加入必須認證的規則配置
		http.authorizeHttpRequests().anyRequest().authenticated();
	}
}
