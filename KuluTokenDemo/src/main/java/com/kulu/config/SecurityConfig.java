package com.kulu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kulu.filter.JwtAuthenticationTokenFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// 提取注入容器的自定的【JwtAuthenticationTokenFilter】
	@Autowired	
	private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
	// 提取認證異常的自定義實現類
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	// 提取權限異常的自定義實現類
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	// 創建 BCryptPasswordEncoder 注入容器
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/** 
	 *  由繼承【WebSecurityConfigurerAdapter】的配置類，重寫【authenticationManagerBean】方法
	 * 	將指定注入容器的【Bean】曝露(公開)
	 *  Override this method to expose the {@link AuthenticationManager} from  
	 *  {@link #configure(AuthenticationManagerBuilder)} to be exposed as a Bean. 
	 */
	@Bean // 注入容器
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	// 進行放行配置，重寫【configure(HttpSecurity http)】方法
	// 讓指定頁面，可不受匿名訪問限制
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				// 關閉CSRF，【進行前後端分離一定要設置】 
				.csrf().disable()
				// 不通過【Session】獲取【SecurityContext】，【進行前後端分離一定要設置】 
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				// permitAll()  Specify that URLs are allowed by anyone.
				.antMatchers("/hello").permitAll()
//				// 對於登入介面，允許匿名訪問
				.antMatchers("/user/login").anonymous()
				/*
				 * 除了在Controller端口方法可以註解設定權限控制，也可以在這邊設定
				 * 對於登入介面，必須擁有hasAuthority所標識的權限才可以訪問
				 */
				.antMatchers("/testCors").hasAuthority("system:dept:list")
//				// 除上面外的所有請求全部需要鑒權認證
				.anyRequest().authenticated();
				
		
		// 這個方法，可以將過濾器增加到另一個過濾器之前(利用自解碼物件標示要新增的過濾器)【添加過濾器】
		http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		// 配置異常處理器
		http.exceptionHandling()
			// 配置認證失敗處理器
			.authenticationEntryPoint(authenticationEntryPoint)
			// 配置授權失敗處理器
			.accessDeniedHandler(accessDeniedHandler);
		
		// 配置允許跨域請求
		http.cors();
	}
}
