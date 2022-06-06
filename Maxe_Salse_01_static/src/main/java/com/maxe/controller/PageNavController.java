package com.maxe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/page")
public class PageNavController {

	@GetMapping(path = "/immediate")
	public String 即時庫存查詢() {
		return "即時庫存查詢.html";
	}
	
	@GetMapping(path = "/theday")
	public String 當日庫存查詢() {
		return "當日庫存查詢.html";
	}
}
