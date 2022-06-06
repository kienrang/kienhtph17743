package com.sof3021.assignment.Controllers.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.AccountModel;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.reposories.AccountRepository;

@Controller
public class LoginController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("login")
	public String Login(Model mol, @ModelAttribute("acc")AccountModel acc) {
		mol.addAttribute("view", "/views/login/login.jsp");
		return "layout";
	}
	
	@PostMapping("login")
	public String Logged(@ModelAttribute("acc")Account acc, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account account = this.accountRepository.findByEmailUser(acc.getEmail());
		int check = 2;
		if(acc.getEmail().equals(account.getEmail()) && acc.getPassword().equals(account.getPassword())) {
			session.setAttribute("user", account);
			if(account.getAdmin()==1) {
				check =1;
			}else {
				check = 0;
			}
		}else {
			session.setAttribute("error", "Email hoặc mật khẩu không đúng!");
		}
		if(check ==1) {
			return "redirect:/admin/index_order";
		}else if(check ==0) {
			return "redirect:/index";
		}else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout") 
	public String logout(HttpServletRequest request, Model mol){
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "redirect:/index";
	}
	
}
