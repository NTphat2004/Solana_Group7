package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	 @RequestMapping("/error")
	    public String handleError(HttpServletRequest request) {
	        // Lấy mã trạng thái của lỗi
	        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	        if (statusCode != null && statusCode == 404) {
	            return "404"; // Trả về tên của file HTML mà bạn đã tạo
	        }
	        return "error"; // Trả về một trang lỗi chung nếu cần
	    }
	 
	 

}
