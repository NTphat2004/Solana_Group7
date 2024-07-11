package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgetPasword {

	@RequestMapping("/ForgetPasword")
		public String ForgetPasword() {
		
		return"ForgetPasword";
	}
	@PostMapping("/doPasword")
	public  String doPasword () {
		
		return"doPasword";
	}
		
	
}