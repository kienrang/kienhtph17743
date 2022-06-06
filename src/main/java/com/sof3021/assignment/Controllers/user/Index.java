package com.sof3021.assignment.Controllers.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.sof3021.assignment.beans.OrderModel;
import com.sof3021.assignment.reposories.OrderDetailRepostory;
import com.sof3021.assignment.reposories.OrderRepository;
import com.sof3021.assignment.reposories.ProductRepository;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.Cart;
import com.sof3021.assignment.entities.Orders;
import com.sof3021.assignment.entities.Products;

@Controller
public class Index {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("index")
	public String Home(Model mol) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		if(acc != null) {
			mol.addAttribute("user", acc);
		}else {
			mol.addAttribute("user", null);
		}
		List<Products> ls =  this.productRepository.findAll();
		mol.addAttribute("ls", ls);
		mol.addAttribute("view", "/views/home.jsp");
		return "layout";
	}
	
	@GetMapping("product/{id}")
	public String product(Model mol,@PathVariable("id")Integer id ) {
		Products pro  = this.productRepository.getOne(id);
		mol.addAttribute("product", pro);
		mol.addAttribute("view", "/views/products/product.jsp");
		return "layout1";
	}
}
