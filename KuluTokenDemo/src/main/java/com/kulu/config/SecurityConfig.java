package com.kulu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// 創建 BCryptPasswordEncoder 注入容器
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/** 
	 *  由繼承【WebSecurityConfigurerAdapter】的配置類，覆寫【authenticationManagerBean】方法
	 * 	將指定注入容器的【Bean】曝露(公開)
	 *  Override this method to expose the {@link AuthenticationManager} from  
	 *  {@link #configure(AuthenticationManagerBuilder)} to be exposed as a Bean. 
	 */
	@Bean // 注入容器
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
}
