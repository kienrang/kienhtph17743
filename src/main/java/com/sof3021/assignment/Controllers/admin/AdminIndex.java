package com.sof3021.assignment.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminIndex {

	@GetMapping("/admin/index")
	public String HomeShow(Model mol) {
		mol.addAttribute("view", "/views/admin/index.jsp");
		return "admin/layoutAdmin";
	}
	
}
