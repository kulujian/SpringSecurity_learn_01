package com.kulu.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  因為是前後端分離的, 因此響應回去的幾乎都是JSON的字串
 *  所以使用注解 @RestController = ( @ResponseBody + @Controller)
 */
@RestController
public class HelloController {

	@RequestMapping(path = "/hello")
	public String hello() {
		return "hello";
	}
}