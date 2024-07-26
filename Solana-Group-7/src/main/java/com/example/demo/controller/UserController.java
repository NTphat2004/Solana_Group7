package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Users;


@Controller
public class UserController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/user/userapp")
	public String getMethodName1(Model model) {
		
		
		
		return "userAPP";
	}

	@GetMapping("/user/checkcoin")
	public String getMethodName(Model model) {
		
		Users UsernameSession =(Users) session.getAttribute("Login");
		System.out.println(session.getAttribute("Login"));
		System.out.println(UsernameSession);
		model.addAttribute("login", UsernameSession);
		
		
		return "myCoin";
	}
	
	@GetMapping("/user/transfer")
	public String getMethodName11(Model model) {
		
		Users UsernameSession =(Users) session.getAttribute("Login");
		
		model.addAttribute("login", UsernameSession);
		
		
		return "TransferCoin";
	}
	
	@GetMapping("/user/language")
	public String getMethodName11111() {
		return "SettingLanguage";
	}
	
	@GetMapping("/user/mynft")
	public String getMethodName111111(Model model) {
		
		return "myNFT";
	}
	
	@GetMapping("/user/listtomarket")
	public String getMethodName1111111(Model model) {
		
		return "ListToMarket";
	}
}
