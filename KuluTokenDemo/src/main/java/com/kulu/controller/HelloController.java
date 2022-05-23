package com.kulu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  因為是前後端分離的, 因此響應回去的幾乎都是JSON的字串
 *  所以使用注解 @RestController = ( @ResponseBody + @Controller)
 */
@RestController
public class HelloController {

	@RequestMapping(path = "/hello")
	@PreAuthorize(value = "hasAuthority('test')") //hasAuthority()，此方法會判斷戶用是否具有()內所標示的權限
	public String hello() {
		return "hello";
	}
}