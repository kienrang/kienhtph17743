package com.sof3021.assignment.Controllers.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.AccountModel;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.reposories.AccountRepository;
import com.sof3021.assignment.utils.EncryptUtil;

@Controller
public class RegisterController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	String email;
	AccountModel acount;
	int confirm;

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
		confirm = code;
		acount = acc;
		mol.addAttribute("code", code);
		mol.addAttribute("view","/views/register/confirmRegister.jsp");		
		return "layout";
	}
	@PostMapping("registerAccount")
	public String register(HttpServletRequest request, Model mol) {
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		if(confirm == Integer.valueOf(code)) {
			Account acc = new Account();
			acc.setEmail(acount.getEmail());
			acc.setFullname(acount.getFullname());
			String pwd = EncryptUtil.encrypt(acount.getPassword());
			acc.setPassword(pwd);
			acc.setPhoto(acount.getPhoto());
			acc.setActivated(1);
			acc.setId(0);
			try {
				this.accountRepository.save(acc);
				session.setAttribute("error", "Đăng kí thành công!");
			} catch (Exception e) {
				
				session.setAttribute("error", "Email của bạn đã có rồi!");
			}
			return "redirect:/login";
		}else {
			session.setAttribute("error", "Đăng kí không thành công!");
			return "redirect:/login";
		}
		
		
	}
	
	
	public Integer random() {
		return (int) ((Math.floor(Math.random() * 1000000)));
	}
}
