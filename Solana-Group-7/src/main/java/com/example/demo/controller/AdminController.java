package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Users;


@Controller
public class AdminController {
	@Autowired
	HttpSession session;
	@GetMapping("admin")
	public String getMethodName(Model model) {
		Users UsernameSession =(Users) session.getAttribute("Login");
		
		model.addAttribute("login", UsernameSession);
		return "Admin";
	}
	

}
