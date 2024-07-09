package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.Users;
import com.example.demo.repository.UserRebository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CRUD_User {
	
	@Autowired
	UserRebository userdao;

	@RequestMapping("/admin/users")
	public String getMethodName(Model model) {
		model.addAttribute("user", new Users());
		return "QLAccount";
	}
	
	@RequestMapping("/admin/users/list")
	public String requestMethodName(Model model) {
		
		List<Users> list = userdao.findAll();
		model.addAttribute("users", list);
		
		return "tableAccount";
	}
	
	@ModelAttribute("roles")
	public List<String> listRoles()
	{
		return Arrays.asList("User","Admin");
	}
	
	@RequestMapping("/admin/users/clear")
	public String requestMethodName1() {
		return "redirect:/admin/users";
	}
	
	
	@PostMapping("/admin/users/save")
	public String postMethodName(@Valid @ModelAttribute("user")Users user, BindingResult error, Model model) {
		
		if(error.hasErrors())
		{
			return "QLAccount";
		}
		
		userdao.save(user);
		System.out.println("thanh cong");
		
		return "redirect:/admin/users";
	}
	
	@PostMapping("/admin/users/update")
	public String postMethodName1(@Valid @ModelAttribute("user")Users user, BindingResult error, Model model) {
		
		if(error.hasErrors())
		{
			return "QLAccount";
		}
		
		userdao.save(user);
		System.out.println("cap nhat thanh cong");
		
		return "redirect:/admin/users";
	}
	
	@PostMapping("/admin/users/edit")
	public String postMethodName(@RequestParam("userId") Integer value,Model model) {
		
		Optional<Users> u = userdao.findById(value);
		if(u.isPresent())
		{
			Users user = u.get();
			model.addAttribute("user", user);
		}
		
		return "QLAccount";
	}
	

}
