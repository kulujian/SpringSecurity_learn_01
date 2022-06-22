package com.kulu.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.kulu.domain.產品庫存MS;
import com.kulu.mapper.產品庫存Mapper;
import com.kulu.service.產品庫存Service;

@Service
@DS(value = "test")
public class 產品庫存ServiceImpl implements 產品庫存Service{

	@Autowired
	private 產品庫存Mapper 產品庫存mapper;

	@Override
	public List<產品庫存MS> findProductBy庫存代號(String model) {
		
//		List<產品庫存MS> 轉出流 = 產品庫存mapper.轉出(model);
//		List<產品庫存MS> 轉入流 = 產品庫存mapper.轉入(model);
//		List<產品庫存MS> 未確認的庫存異動單流 = 產品庫存mapper.未確認的庫存異動單(model);
//		List<產品庫存MS> 未確認的銷貨單流 = 產品庫存mapper.未確認的銷貨單(model);
//		List<產品庫存MS> 原始單據流 = 產品庫存mapper.原始單據(model);
//		List<產品庫存MS> 搜詢結果 = Stream.of(轉出流, 轉入流, 未確認的庫存異動單流, 未確認的銷貨單流, 原始單據流)
//										  .flatMap(Collection<產品庫存MS>::stream).filter(t -> t.get現有存量() != 0)
//										  .collect(Collectors.toList());
		List<產品庫存MS> 搜詢結果 = 產品庫存mapper.一步到位(model);
		return 搜詢結果;
	}
}
