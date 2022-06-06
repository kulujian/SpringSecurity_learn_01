package com.maxe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxe.domain.當日庫存;
import com.maxe.mapper.當日庫存Mapper;
import com.maxe.service.當日庫存Service;

@Service
public class 當日庫存ServiceImpl implements 當日庫存Service{

	// 注入Mapper
	@Autowired
	private 當日庫存Mapper 當日庫存mapper;
	
	@Override
	public List<當日庫存> findInventory(String date, String model, String storehouse) {
		List<當日庫存> 搜詢結果 = 當日庫存mapper.查詢(date, model, storehouse);
		return 搜詢結果;
	}

}
