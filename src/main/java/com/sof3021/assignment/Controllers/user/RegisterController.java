package com.sof3021.assignment.Controllers.user;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.AccountModel;

@Controller
public class RegisterController {
	
	String email = null;
	AccountModel acount;

	@GetMapping("register")
	public String registerShow(Model mol) {
		mol.addAttribute("view","/views/register/register.jsp");		
		return "layout";
	}
	@GetMapping("register_info")
	public String registerInfo(Model mol, HttpServletRequest request,@ModelAttribute("acc") AccountModel acc) {
		email = request.getParameter("email");
		System.out.println("ché----------->"+email);
		if (email.equals("")) {
			System.out.println("Ché ràng");
			//Xử lí trả lỗi
			return "redirect:/register";
		}else {
			mol.addAttribute("view","/views/register/register_info.jsp");		
			return "layout";
		}
		
	}
	@PostMapping("register_confirm")
	public String registerConfirm(Model mol, @ModelAttribute("acc") AccountModel acc) {
		acc.setEmail(email);
		System.out.println(acc.toString());
		Integer code = random();
		acount = acc;
		mol.addAttribute("code", code);
		mol.addAttribute("view","/views/register/confirmRegister.jsp");		
		return "layout";
	}
	@PostMapping("registerAccount")
	public String register(HttpServletRequest request, Model mol) {
		System.out.println(acount.toString());
		String code = request.getParameter("code");
		System.out.println(code);
		// Tạo 1 account mới rồi gán các thông tin vào rồi thêm
		return "redirect:/login";
	}
	
	
	public Integer random() {
		return (int) ((Math.floor(Math.random() * 1000000)));
	}
}
