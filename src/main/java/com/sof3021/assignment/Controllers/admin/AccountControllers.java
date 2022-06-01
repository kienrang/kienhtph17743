package com.sof3021.assignment.Controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021.assignment.beans.AccountModel;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.reposories.AccountRepository;

@Controller
public class AccountControllers {
	
	@Autowired
	private AccountRepository accRepository;
	
	@GetMapping("/admin/index_user")
	public String index(Model mol	
			) {
		List<Account> ds = this.accRepository.findAll();
		mol.addAttribute("lsUser", ds);
		mol.addAttribute("view", "/views/admin/UserIndex.jsp");
		return "admin/layoutAdmin";
	}
	@GetMapping("/admin/create_user")
	public String create(Model mol,@ModelAttribute("user") AccountModel user) {
		mol.addAttribute("view", "/views/admin/UserCreate.jsp");
	
		return "admin/layoutAdmin";
	}
	@PostMapping("/admin/store_user")
	public String store(@ModelAttribute("user") AccountModel user) {
		
		Account acc = new Account();
		acc.setFullname(user.getFullname());
		acc.setEmail(user.getEmail());
		acc.setPassword(user.getPassword());
		acc.setPhoto(user.getPhoto());
		acc.setActivated(user.getActivated());
		acc.setId(0);
		acc.setAdmin(0);
		
		try {
			this.accRepository.save(acc);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/index_user";
	}
	@GetMapping("/admin/edit_user/{id}")
	public String edit(Model mol,@PathVariable("id") Account user) {
		mol.addAttribute("user", user);
		mol.addAttribute("view", "/views/admin/Users/UserEdit.jsp");
		return "admin/layoutAdmin";
	}
	@PostMapping("/admin/update_user")
	public String update(@ModelAttribute("user")AccountModel user) {
		return "redirect:/admin/index_user";
	}
	
	
	@GetMapping("/admin/delete_user/{id}")
	public String Delete(@PathVariable("id")Account user) {
		this.accRepository.delete(user);
		return "redirect:/admin/index_user";
	}
}
