package com.kulu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * 啟動類建立
 * 1. 加上宣告注解【@SpringBootApplication】
 * 2. 添加main方法
 * 3. 新增屬性【SpringApplication.run(啟動類自解碼物件,args)】
 * 4. 若有使用MyBatis需配置Mapper掃描【@MapperScan(value = "com.kulu.mapper")】,value 指定掃描路徑
 */
@SpringBootApplication
@MapperScan(value = "com.kulu.mapper")
public class TokenApplication {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext run  =
		SpringApplication.run(TokenApplication.class, args);
		System.out.println(run);
	}
}
