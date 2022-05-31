package com.maxe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.maxe.domain.產品庫存MS;

/*
 *  使用MyBatis
 *  1. 建立一個*Mapper介面
 *  2. 定義*Mapper介面的方法
 *  3. 添加【@Mpper】，宣告為Mapper介面，使MyBatis能夠識別
 *  4. 添加【@Repository】，與@Component一樣，都是將對應物件放置SpringBoot容器內。
 *                          在這邊的對應物件是MyBatis幫忙注入，不添加也可以。
 *                          但若有些IDE工具在Controller @Atuowired注入時報錯(不影響功能)時，在此添加注解可以消除。
 *  
 *  介面的實現體 不需要自己創建
 *  只要對定義Mappre成生對應的XML映射文件，然後在映射文件生成對應的標籤，在標籤內寫上對應的SQL語句
 *  
 */
@Mapper
@Repository 
public interface 產品庫存Mapper {

	List<產品庫存MS> 轉出(@Param("model")String model);
	List<產品庫存MS> 轉入(@Param("model")String model);
	List<產品庫存MS> 未確認的庫存異動單(@Param("model")String model);
	List<產品庫存MS> 未確認的銷貨單(@Param("model")String model);
	List<產品庫存MS> 原始單據(@Param("model")String model);
	List<產品庫存MS> 一步到位(@Param("model")String model);
	
}
