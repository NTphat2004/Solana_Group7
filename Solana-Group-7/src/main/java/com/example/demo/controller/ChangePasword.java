package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangePasword {

	@RequestMapping("/ForgetPasword1")
	public String ForgetPasword3() {
	
	return"ForgetPasword";
}
}
