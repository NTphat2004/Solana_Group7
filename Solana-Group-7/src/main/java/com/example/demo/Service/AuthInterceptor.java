package com.example.demo.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.Entity.*;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SesscionService session;
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			String uri = request.getRequestURI();
			Users user = session.getValue("Login"); // lấy từ session
			String error = "";
			if(user == null) { // chưa đăng nhập
			error = "Please login!";
			}
			// không đúng vai trò
			else if(!user.getRole().equals("Admin") && uri.startsWith("/admin/")) {
			error = "You are not right to use this FUNCTION, so you have to log out  ";
			}
			if(error.length() > 0) { // có lỗi
			session.setvalue(uri, error);
			response.sendRedirect("/login?error=" + error);
			return false;
			
			}
			
			return true;
			
			
			}
	
	
	
			}


