package com.sof3021.assignment.Controllers.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.sof3021.assignment.utils.EncryptUtil;

@Controller
public class AccountControllers {
	
	@Autowired
	private AccountRepository accRepository;
	
	@GetMapping("/admin/index_user")
	public String index(Model mol,@ModelAttribute("user") AccountModel user, @RequestParam("p") Optional<Integer> p) {
		List<Account> ds = this.accRepository.findByAtiveUser(1,0);
		mol.addAttribute("lsUser", ds);
//		Pageable pageable=PageRequest.of(p.orElse(0), 3);
//		Page<Account>page= this.accRepository.findAll(pageable);
//		mol.addAttribute("lsUser", page);
		
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
		String pwd = EncryptUtil.encrypt(user.getPassword());		
		acc.setPassword(pwd);
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
	public String edit(Model mol,@PathVariable("id") Integer id) {
		System.out.println(id);
		mol.addAttribute("user", this.accRepository.findByIdUser(id));
		mol.addAttribute("view", "/views/admin/UserEdit.jsp");
		return "admin/layoutAdmin";
	}
	@PostMapping("/admin/update_user/{id}")
	public String update(@ModelAttribute("user")AccountModel user,@PathVariable("id") Integer id) {
		Account acc =  this.accRepository.getOne(id);
		acc.setEmail(user.getEmail());
		acc.setFullname(acc.getFullname());
		String pwd = EncryptUtil.encrypt(user.getPassword());
		acc.setPassword(pwd);
		if(user.getPhoto() != null) {
			acc.setPhoto(user.getPhoto());
		}
		acc.setId(id);
		acc.setActivated(user.getActivated());
		acc.setAdmin(0);
		
		this.accRepository.save(acc);
		
		return "redirect:/admin/index_user";
	}
	
	
	@GetMapping("/admin/delete_user/{id}")
	public String Delete(@PathVariable("id")Account user) {
		Account a = this.accRepository.getOne(user.getId());
		a.setActivated(0);
		this.accRepository.save(a);
		return "redirect:/admin/index_user";
	}
}
