package com.sof3021.assignment.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.entities.Account;

@Controller
public class UserControllers {
	@GetMapping("/admin/index_user")
	public String index(Model mol) {
		mol.addAttribute("view", "/views/admin/UserIndex.jsp");
		return "admin/layoutAdmin";
	}
	@GetMapping("/admin/create_user")
	public String create(Model mol,@ModelAttribute("user") Account user) {
		mol.addAttribute("view", "/views/admin/UserCreate.jsp");
		
		return "admin/layoutAdmin";
	}
	@PostMapping("/admin/store_user")
	public String store(@ModelAttribute("user") Account user) {
		System.out.println("---Vào post---");
		System.out.println(user.getEmail());
		return "redirect:/admin/index_user";
	}
	@GetMapping("/admin/edit_user")
	public String edit(Model mol,@ModelAttribute("user")Account user) {
		mol.addAttribute("view", "/views/admin/UserEdit.jsp");
		return "admin/layoutAdmin";
	}
	@PostMapping("/admin/update_user")
	public String update(@ModelAttribute("user")Account user) {
		
		return "redirect:/admin/index_user";
	}
	@PostMapping("/admin/delete_user")
	public String Delete(@ModelAttribute("user")Account user) {
		return "redirect:/admin/index_user";
	}
}
