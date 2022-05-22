package com.kulu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kulu.filter.JwtAuthenticationTokenFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// 提取注入容器的自定的【JwtAuthenticationTokenFilter】
	@Autowired
	private JwtAuthenticationTokenFilter JwtAuthenticationTokenFilter;
	
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
				// 對於登入介面，允許匿名訪問
				.antMatchers("/user/login").anonymous()
				// 除上面外的所有請求全部需要鑒權認證
				.anyRequest().authenticated();
		
		// 這個方法，可以將過濾器增加到另一個過濾器之前(利用自解碼物件標示要新增的過濾器)
		http.addFilterBefore(JwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
