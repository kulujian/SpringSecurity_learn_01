package com.kulu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * 啟動類建立
 * 1. 加上宣告注解【@SpringBootApplication】
 * 2. 添加main方法
 * 3. 新增屬性【SpringApplication.run(啟動類自解碼物件,args)】
 */
@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SecurityApplication.class, args);
		System.out.println(111);
	}
}
