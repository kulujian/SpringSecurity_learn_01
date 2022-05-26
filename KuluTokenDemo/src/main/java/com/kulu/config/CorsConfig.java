package com.kulu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域運行請求設定
 * 
 * 1. 先實作【WebMvcCfonigurer】介面 
 * 2. 重寫【addCorsMappings】方法
 * @author kulu.jian
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 設置允許跨域請求的路徑
		registry.addMapping("/**")
				// 設置允許跨域請求的域名
				.allowedOriginPatterns("*")
				// 設置是否允許cookie
				.allowCredentials(true)
				// 設置允許的請求方式
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				// 設置允許的 header屬性
				.allowedHeaders("*")
				// 設置跨域允許時間(秒)
				.maxAge(3600);
	}
}
