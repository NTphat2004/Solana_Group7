package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Users;
import com.example.demo.Service.Cookies;
import com.example.demo.repository.UserRebository;

@Controller
public class SignUpController {
	
	@GetMapping("/signUp")
	public String SignUpIndex(@ModelAttribute("user") Users u) {	
		
		return"SignUp";
	}
	
	@PostMapping("/doSign")
	public  String doSign () {
		
		return"mailRegister";
	}

		
	
}
