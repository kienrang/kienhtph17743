package com.sof3021.assignment.Controllers.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sof3021.assignment.entities.Account;

@Controller
public class AdminIndex {
	@GetMapping("admin/index")
	public String HomeShow(Model mol, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		System.out.println("ché ---------->" + acc.toString());
		mol.addAttribute("view", "/views/admin/index.jsp");
		return "admin/layoutAdmin";
	}
	@GetMapping("admin/doanhthu")
	public String doanhthu(Model mol, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		mol.addAttribute("view", "/views/admin/doanhthu.jsp");
		return "admin/layoutAdmin";
	}
	
}
