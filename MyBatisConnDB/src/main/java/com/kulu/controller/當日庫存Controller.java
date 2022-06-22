package com.kulu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulu.domain.ResponseResult;
import com.kulu.domain.當日庫存;
import com.kulu.service.當日庫存Service;

@CrossOrigin 	// 加在方法上，只允許加註方法跨域請求(此註解無細部設定，算是快速開啟跨域連線的小撇步) 
@RestController
@RequestMapping(path = "/product")
public class 當日庫存Controller {

	// 注入Service
	@Autowired
	private 當日庫存Service 當日庫存service;
	
	@PostMapping(path = "/當日")
	public ResponseResult findInventory(
			@RequestBody Map<String, String> data) {
		
		List<當日庫存> 在庫明細 = 當日庫存service.findInventory(data.get("date").replace("-", ""), data.get("model"), data.get("storehouse"));
//		List<當日庫存> 在庫明細 = 當日庫存service.findInventory("20220520", "MRV-052HMD", "A4001");
//		System.out.println(data.get("date"));
//		System.out.println(data.get("model"));
//		System.out.println(data.get("storehouse"));
		return new ResponseResult<>(200, "查詢完畢", 在庫明細);
	}
}
