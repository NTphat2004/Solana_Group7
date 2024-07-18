package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Favorites;
import com.example.demo.Entity.NFTs;
import com.example.demo.Entity.Users;
import com.example.demo.repository.FavoriteRepository;
import com.example.demo.repository.NftRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class favoriteNFTcontroller {

	@Autowired
	HttpSession session;
	@Autowired
	FavoriteRepository dao;
	@Autowired
	NftRepository daonft;
	
	@GetMapping("user/favoritenft")
	public String getMethodName(Model model) {
		Users userne = (Users) session.getAttribute("Login");
		List<Favorites> listf = dao.findallbyuser(userne.getUserId());
		model.addAttribute("listf", listf);
		return "favoriteNFT";
	}
	
	@RequestMapping("/user/favoritenft/{nftid}")
	public String requestMethodName(@PathVariable("nftid") Integer idnft) {
		
		Users userne = (Users) session.getAttribute("Login");
		
	
		Favorites f = new Favorites();
		NFTs nftfind = daonft.findbynftId(idnft);
		f.setUser(userne);
		f.setNft(nftfind);
		 dao.save(f); 
		return "redirect:/user/favoritenft";
	}
	
	@RequestMapping("/user/favorite/delete")
	public String requestMethodName11(@RequestParam("fId")Integer idf) {
		dao.deleteById(idf);
		return "redirect:/user/favoritenft";
	}
	

}
