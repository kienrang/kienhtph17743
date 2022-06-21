package com.sof3021.assignment.Controllers.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.AccountModel;
import com.sof3021.assignment.beans.LoginModel;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.reposories.AccountRepository;
import com.sof3021.assignment.utils.EncryptUtil;

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
	public String Logged(@ModelAttribute("acc")LoginModel acc, HttpServletRequest request, BindingResult result) {
		HttpSession session = request.getSession();
		if(acc.getEmail().equals("")) {
			session.setAttribute("error", "Email không được để trống");
			return "redirect:/login";
		}else if(acc.getEmail().matches("\\w+@\\w+.com")==false)  {
			session.setAttribute("error", "Email không đúng định dạng");
			return "redirect:/login";
		}else if(acc.getPassword().equals("")){
			session.setAttribute("error", "Mật khẩu không được để trống");
			return "redirect:/login";
		}else if(acc.getPassword().length() < 6){
			session.setAttribute("error", "Mật khẩu không dưới 6 kí tự");
			return "redirect:/login";
		}
		
		Account account = this.accountRepository.findByEmailUser(acc.getEmail());
		int check = 2;
		
		boolean ck = EncryptUtil.check(acc.getPassword(), account.getPassword());
		
		if(acc.getEmail().equals(account.getEmail()) && ck==true) {
			if(account.getAdmin()==1) {
				session.setAttribute("user", account);
				check =1;
			}else if (account.getActivated() == 0) {
				check = 3;
			}else {
				session.setAttribute("user", account);
				check = 0;
			}
		}else {
			session.setAttribute("error", "Email hoặc mật khẩu không đúng!");
		}
		if(check ==1) {
			return "redirect:/admin/index_order";
		}else if(check ==0) {
			return "redirect:/index";
		}else if (check == 3) {
			session.setAttribute("error", "Tài khoản của bạn đã bị khóa");
			return "redirect:/login";
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
