package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Comments;
import com.example.demo.Entity.NFTs;
import com.example.demo.Entity.Users;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.NftRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class NFTController {
	
	@Autowired
	NftRepository nftdao;
	@Autowired
	CommentRepository commentdao;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/nft/detail/{value}")
	public String getMethodName(Model model,@PathVariable("value")String value) {
		System.out.println(value);
		NFTs findnft = nftdao.findbyadress(value);
		if (findnft!=null) {
	        model.addAttribute("nft", findnft);
	    } 
	List<Comments> listcomment = commentdao.findCommentsByNFTsnftAddress(value);
	model.addAttribute("listcm", listcomment);
	Integer countcomment = commentdao.countByIdNft(value);
	model.addAttribute("countcomment", countcomment);
		return "NFTDetail";
	}
	
//	@GetMapping("/nft/detail/{value}")
//	public String getMethodName(Model model,@PathVariable("value")Integer value) {
//		System.out.println(value);
//		Optional<NFTs> findnft = nftdao.findById(value);
//		if (findnft.isPresent()) {
//	        model.addAttribute("nft", findnft.get());
//	    } 
//	List<Comments> listcomment = commentdao.findCommentsByNFTs(value);
//	model.addAttribute("listcm", listcomment);
//	Integer countcomment = commentdao.countByIdNft(value);
//	model.addAttribute("countcomment", countcomment);
//		return "NFTDetail";
//	}
	
	@GetMapping("nft/detail/comment/{value}")
	public String MethodName11(Model model,@PathVariable("value")String value,@RequestParam("content") String content) {
		
		NFTs findnft = nftdao.findbyadress(value);
		System.out.println(findnft.getNftId()+"nft");
	    Users user = (Users) session.getAttribute("Login");
		Date now = new Date();
		Comments comment = new Comments();
		comment.setCommentContent(content);
		comment.setCommentDate(now);
		comment.setNft(findnft);
		comment.setUser(user);
		commentdao.save(comment);
		return "redirect:/nft/detail/"+value;
	}
	

}
