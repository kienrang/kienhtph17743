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
import com.sof3021.assignment.reposories.CategoryRepository;
import com.sof3021.assignment.reposories.OrderDetailRepostory;
import com.sof3021.assignment.reposories.OrderRepository;
import com.sof3021.assignment.reposories.ProductRepository;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.Cart;
import com.sof3021.assignment.entities.Categories;
import com.sof3021.assignment.entities.Orders;
import com.sof3021.assignment.entities.Products;

@Controller
public class Index {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("index")
	public String Home(Model mol) {
//		List<Categories> lsc = this.categoryRepository.findAll();
//		mol.addAttribute("lsc", lsc);
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
		List<Categories> lsc = this.categoryRepository.findAll();
		mol.addAttribute("lsc", lsc);
		mol.addAttribute("product", pro);
		mol.addAttribute("view", "/views/products/product.jsp");
		return "layout1";
	}
	
	@GetMapping("category/{id}")
	public String showCategory(Model mol, @PathVariable("id") Integer id) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		if(acc != null) {
			mol.addAttribute("user", acc);
		}else {
			mol.addAttribute("user", null);
		}
		Categories categories = this.categoryRepository.getOne(id);
		List<Products> ls =  this.productRepository.findByProductEqualCate(categories);
		mol.addAttribute("ls", ls);
		mol.addAttribute("view", "/views/index1.jsp");
		return "layout1";
	}
}
