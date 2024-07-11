package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Advertisements;
import com.example.demo.Entity.Users;
import com.example.demo.repository.ADRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CRUD_Ad {
	
	@Autowired
	ADRepository addao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("admin/ad")
	public String getMethodName(Model model) {
		
		model.addAttribute("ad", new Advertisements());
		
		return "QLAdvertisement";
	}
	
	@PostMapping("admin/ad/save")
	public String postMethodName(@Valid @ModelAttribute("ad")Advertisements ad, BindingResult error ,Model model,@RequestParam("file") MultipartFile photo) {
		
		if (photo.isEmpty()) {
			error.rejectValue("adImageUrl", "adImageUrl.emptyFile", "Banner is required");
			System.out.println(photo.getOriginalFilename());
		}
		if(error.hasErrors())
		{
			return "QLAdvertisement";
		}
		Users u = (Users) session.getAttribute("Login");
		ad.setUser(u);
		ad.setAdImageUrl(photo.getOriginalFilename());
		addao.save(ad);
		System.out.println("thanh cong");
		return "redirect:/admin/ad";
	}
	
	@PostMapping("admin/ad/update")
	public String postMethodName1(@Valid @ModelAttribute("ad")Advertisements ad, BindingResult error ,Model model,@RequestParam("file") MultipartFile photo) {
		
		if (photo.isEmpty()) {
			error.rejectValue("adImageUrl", "adImageUrl.emptyFile", "Banner is required");
			System.out.println(photo.getOriginalFilename());
		}
		if(error.hasErrors())
		{
			return "QLAdvertisement";
		}
		Users u = (Users) session.getAttribute("Login");
		ad.setUser(u);
		ad.setAdImageUrl(photo.getOriginalFilename());
		addao.save(ad);
		System.out.println("thanh cong");
		return "redirect:/admin/ad";
	}
	
	@RequestMapping("admin/ad/list")
	public String requestMethodName(Model model) {
		
		List<Advertisements> listadv = addao.findAll();
		model.addAttribute("listadne", listadv);
		
		return "tablead";
	}
	
	@RequestMapping("admin/ad/clear")
	public String requestMethodName1() {
		
		return "redirect:/admin/ad";
	}
	
	@PostMapping("/admin/ad/edit")
	public String postMethodName(Model model,@RequestParam("adId") Integer id) {
		
		Optional<Advertisements> ad = addao.findById(id);
		model.addAttribute("ad", ad);
		return "QLAdvertisement";
	}
	
}
