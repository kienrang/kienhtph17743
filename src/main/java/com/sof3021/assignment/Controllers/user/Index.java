package com.sof3021.assignment.Controllers.user;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sof3021.assignment.beans.OrderModel;

@Controller
public class Index {

	@GetMapping("index")
	public String Home(Model mol) {
		mol.addAttribute("view", "/views/home.jsp");
		return "layout";
	}
	
	@GetMapping("cart")
	public String Cart(Model mol,@ModelAttribute("order")OrderModel order) {
		mol.addAttribute("view", "/views/users/cart.jsp");
		return "layout";
	}
	@GetMapping("product")
	public String product(Model mol) {
		mol.addAttribute("view", "/views/products/product.jsp");
		return "layout";
	}
}
