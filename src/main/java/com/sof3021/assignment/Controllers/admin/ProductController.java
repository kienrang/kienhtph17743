package com.sof3021.assignment.Controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.ProductModel;
import com.sof3021.assignment.entities.Products;
import com.sof3021.assignment.reposories.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/admin/index_product")
	public String index(Model mol) {
		List<Products> ls = this.productRepository.findAll();
		mol.addAttribute("ds", ls);
		mol.addAttribute("view", "/views/admin/ProductIndex.jsp");
		return "admin/layoutAdmin";
	}
	@GetMapping("/admin/create_product")
	public String create(Model mol,@ModelAttribute("product") ProductModel product) {
		
		mol.addAttribute("view", "/views/admin/ProductCreate.jsp");
		return "admin/layoutAdmin";
	}
	
	@PostMapping("/admin/store_product")
	public String store(@ModelAttribute("product") Products product) {
		System.out.println("----Vào Store-----");
		return "redirect:/admin/index_product";
	}
	@GetMapping("/admin/edit_product")
	public String edit(Model mol,@ModelAttribute("product") Products product) {
		mol.addAttribute("view", "/views/admin/ProductEdit.jsp");
		return "admin/layoutAdmin";
	}
	@PostMapping("/admin/update_product")
	public String update(@ModelAttribute("product") Products product) {
		System.out.println("----Vào update-----");
		return "redirect:/admin/index_product";
	}
	@GetMapping("/admin/delete_product")
	public String delete(@ModelAttribute("product") Products product) {
		System.out.println("----Vào delete-----");
		return "redirect:/admin/index_product";
	}
}
