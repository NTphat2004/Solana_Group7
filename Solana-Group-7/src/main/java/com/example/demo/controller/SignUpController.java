package com.example.demo.controller;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Users;
import com.example.demo.Service.MailerService;
import com.example.demo.repository.UserRebository;
import com.example.demo.Entity.MailInfo;

@RequestMapping("/signup")
@Controller
public class SignUpController {

	@Autowired
	MailerService mailer;

	@Autowired
	ServletContext context;

	@Autowired
	UserRebository userDao;

	@GetMapping("/index")
	public String SignUpIndex(@ModelAttribute("user") Users u) {

		return "SignUp";
	}

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
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
		context.setAttribute("mail", mail);
		context.setAttribute("optset", getRandomNumberString());

		MailInfo mail1 = new MailInfo(mail, "Mã OPT cho đơn thanh toán ", mailer.bodyTemplate());

		try {
			mailer.send(mail1);
			System.out.println("Ok");
		} catch (MessagingException e) {

			e.printStackTrace();
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
		if (opt.equalsIgnoreCase((String) context.getAttribute("optset"))) {
			model.addAttribute("mail",context.getAttribute("mail"));
			return "SignUp2";

		} else

			return "mailRegister";
	}

	@RequestMapping("/newacc")
	public String createNewAcc(@RequestParam(name = "opt", required = false) String opt, Model model,
			@RequestParam(name = "mail", required = false) String mail,
			@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password,
			@RequestParam(name = "fullname", required = false) String fullname, @ModelAttribute("user") Users u,
			BindingResult rs) {

		u.setEmail(mail);
		u.setFullname(fullname);
		u.setPassword(password);
		u.setRole("User");
		u.setUsername(username);
		u.setWalletAddress("");

		try {
			userDao.save(u);
			System.out.println(u.getPassword());
			return "redirect:/home";
		} catch (Exception e) {
	
		}

		return "mailRegister";
	}
}
