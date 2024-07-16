package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Advertisements;
import com.example.demo.Entity.NFTs;
import com.example.demo.Entity.Users;
import com.example.demo.Service.Cookies;
import com.example.demo.repository.ADRepository;
import com.example.demo.repository.NftRepository;
import com.example.demo.repository.UserRebository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {

	@Autowired
	HttpSession session;
	@Autowired
	Cookies cookie;
	@Autowired
	HttpServletRequest req;
	@Autowired
	UserRebository userdao;
	@Autowired
	HttpServletResponse rep;
	@Autowired
	ADRepository addao;
	@Autowired
	NftRepository nftdao;

	
	@GetMapping("home")
	public String getMethodName(Model model) {
//		String username = cookie.get("username", req);
//		String password = cookie.get("password", req);
//		Users u = userdao.findByUsername(username);
//		if(u!=null)
//		{
//			if(password.equalsIgnoreCase(u.getPassword()))
//			{
//				session.setAttribute("Login", u);
//				cookie.add("username", username, 2, rep);
//				cookie.add("password",password, 2, rep);
//				System.out.println(session.getAttribute("Login"));
//				
//			}	
//		}	
	
	
	List<Advertisements> listad1111 = addao.findAll();
	model.addAttribute("listad1111", listad1111);
	
	List<NFTs> listNFT = nftdao.findAll();
	model.addAttribute("listnft", listNFT);
	
	List<NFTs> top2nft = nftdao.findTop2ByPrice();
	model.addAttribute("listtop2", top2nft);
	
	
	
	
		return "Home";
	}
	
	@GetMapping("/updatewallet/{key}")
	public String requestMethodName(@PathVariable("key")String wallet) {
		
		System.out.println("wallet : "+wallet);
		Users Userupdatewl =(Users) session.getAttribute("Login");
		Userupdatewl.setWalletAddress(wallet);
		userdao.save(Userupdatewl);
		System.out.println("them vi thanh cong");
		
		return "redirect:/home";
	}
	
	@RequestMapping("/home/mynft")
	public String requestMethodName12()
	{
		return "myNFT";
	}
	  @GetMapping("/")
	    public String index() {
	        return "BuyNFT";
	    }

}
