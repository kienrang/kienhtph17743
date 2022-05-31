package com.sof3021.assignment.Controllers.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.entities.Account;

@Controller
public class LoginController {
	
	@GetMapping("login")
	public String Login(Model mol, @ModelAttribute("acc")Account acc) {
		mol.addAttribute("view", "/views/login/login.jsp");
		return "layout";
	}
	
	@PostMapping("login")
	public String Logged(@ModelAttribute("acc")Account acc) {
		System.out.println(acc.getEmail());
		System.out.println(acc.getPassword());
		return "redirect:/index";
	}
	
}
