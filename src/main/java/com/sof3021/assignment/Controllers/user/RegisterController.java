package com.sof3021.assignment.Controllers.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

	@GetMapping("register")
	public String registerShow(Model mol) {
		mol.addAttribute("view","/views/register/register.jsp");		
		return "layout";
	}
	@GetMapping("register_info")
	public String registerInfo(Model mol) {
		mol.addAttribute("view","/views/register/register_info.jsp");		
		return "layout";
	}
	@GetMapping("register_confirm")
	public String registerConfirm(Model mol) {
		mol.addAttribute("view","/views/register/confirmRegister.jsp");		
		return "layout";
	}
}
