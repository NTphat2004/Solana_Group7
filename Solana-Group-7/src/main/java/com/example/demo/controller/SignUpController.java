package com.example.demo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Users;

@RequestMapping("/signup")
@Controller
public class SignUpController {

	@GetMapping("/index")
	public String SignUpIndex(@ModelAttribute("user") Users u) {

		return "SignUp";
	}

	@PostMapping("/do")
	public String doSign(Model model, @RequestParam("mail") String mail, @ModelAttribute("user") Users u,
			BindingResult rs) {
		if (mail.isBlank()) {
			model.addAttribute("error", "Email bị trống");
			return "SignUp";
		} else {
			if (!validate(mail)) {
				model.addAttribute("error", "sai định dạng email");
				return "SignUp";
			}
		}
		return "mailRegister";
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.matches();
	}

	@RequestMapping("/inputopt")
	public String doOpt(@RequestParam(name = "opt", required = false) String opt, Model model,
			@RequestParam(name = "mail", required = false) String mail, @ModelAttribute("user") Users u,
			BindingResult rs) {
		return "mailRegister";
	}
}
