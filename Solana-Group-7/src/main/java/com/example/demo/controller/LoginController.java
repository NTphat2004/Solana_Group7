package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Users;
import com.example.demo.Service.Cookies;
import com.example.demo.repository.UserRebository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class LoginController {
	
	@Autowired
	UserRebository userdao;
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletResponse rep;
	@Autowired
	HttpServletRequest req;
	@Autowired
	Cookies cookie;
	
	@RequestMapping("login")
	public String getMethodName(Model model) {
        Users user = new Users();
		String username = cookie.get("username", req);
		String password = cookie.get("password", req);
		System.out.println(username);
		System.out.println(password);
		if(username!=null || password !=null)
		{	
			user.setUsername(username);
			user.setPassword(password);
			model.addAttribute("check", true);
			model.addAttribute("user", user);
		}
		else {
			model.addAttribute("user", new Users());
		}
		return "Login";
	}
	
	@PostMapping("/login/do")
	public String postMethodName(@Valid @ModelAttribute("user") Users user,BindingResult error, Model model,@RequestParam(name = "checked",defaultValue = "")String check) {
		
		int time = check == null ?0:2;
		System.out.println(time);
		
		if(error.hasErrors())
		{
			return "Login";
		}
		
		Users find =  userdao.findByUsername(user.getUsername());
		if(find!=null)
		{
			if(user.getPassword().equalsIgnoreCase(find.getPassword()))
			{
				session.setAttribute("Login", find);
				cookie.add("username", user.getUsername(), time, rep);
				cookie.add("password", user.getPassword(), time, rep);
				System.out.println(session.getAttribute("Login"));
				if(find.getRole().equals("Admin"))
				{
					System.out.println("this is admin");
					return "redirect:/admin";
				}
				return "redirect:/home";
			}
			else
			{
				cookie.delete("username", rep);
				cookie.delete("password", rep);
			}
		}
		else
		{	
			cookie.delete("username", rep);
			cookie.delete("password", rep);
		}
		
		
		
		
		return "Login";
	}
	
	@RequestMapping("/logout")
	public String requestMethodName(Model model) {
		
		session.removeAttribute("Login");
		cookie.delete("username", rep);
		cookie.delete("password", rep);
		return "redirect:/login";
	}
	
	
}
