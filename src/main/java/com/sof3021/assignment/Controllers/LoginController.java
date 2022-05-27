package com.sof3021.assignment.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("login")
	public String Login(Model mol) {
		mol.addAttribute("view", "/views/login/login.jsp");
		return "layout";
	}
	
}
