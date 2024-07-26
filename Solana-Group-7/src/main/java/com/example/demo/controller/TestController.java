package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/user/createnft")
	public String getMethodName() {
		return "NewFile1";
	}
	
	@GetMapping("/test/shownft")
	public String getMethodName1() {
		return "hometest2";
	}
	

}
