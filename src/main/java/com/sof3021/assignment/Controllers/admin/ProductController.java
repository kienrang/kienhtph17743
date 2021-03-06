package com.sof3021.assignment.Controllers.admin;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021.assignment.beans.ProductModel;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.Categories;
import com.sof3021.assignment.entities.Products;
import com.sof3021.assignment.reposories.CategoryRepository;
import com.sof3021.assignment.reposories.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("admin/index_product")
	public String show(Model mol,@ModelAttribute("product")ProductModel product, @RequestParam("p") Optional<Integer> p) {
//		List<Products> ls = this.productRepository.findAll();
		
		Pageable pageable=PageRequest.of(p.orElse(0), 3);
		Page<Products>ls= this.productRepository.findAll(pageable);
		
		List<Categories> ds = this.categoryRepository.findAll();
		mol.addAttribute("cate", ds);
		mol.addAttribute("ds", ls);
		mol.addAttribute("view", "/views/admin/ProductIndex.jsp");
		return "admin/layoutAdmin";
	}
	
	@GetMapping("admin/create_product")
	public String create(Model mol, @ModelAttribute("product")ProductModel product) {
		List<Categories> ds = this.categoryRepository.findAll();
		mol.addAttribute("cate", ds);
		mol.addAttribute("view", "/views/admin/ProductCreate.jsp");
		return "admin/layoutAdmin";
	}
	
	@PostMapping("admin/store_product")
	public String store(@ModelAttribute("product")ProductModel product) {
		Products pro = new Products();
		pro.setName(product.getName());
		pro.setImage(product.getImage());
		pro.setPrice(Integer.valueOf(product.getPrice()));
		pro.setQuantity(product.getQuantity());
		pro.setAvailable(1);
		pro.setNote(product.getNote());
		Date now = new Date();
		pro.setCreated_date(now);
		System.out.println(product.toString());
		pro.setCategory(this.categoryRepository.findByCateEqual(product.getCategory_id()));
		
		this.productRepository.save(pro);
		return "redirect:/admin/index_product";
	}
	
	@GetMapping("admin/edit_product/{id}")
	public String edit(Model mol,@PathVariable("id") Integer id, @ModelAttribute("product") ProductModel product) {
		
		List<Categories> ds = this.categoryRepository.findAll();
		mol.addAttribute("cate", ds);
		mol.addAttribute("view", "/views/admin/ProductEdit.jsp");
		return "admin/layoutAdmin";
	}
	
	@PostMapping("admin/update_product/{id}")
	public String update(@ModelAttribute("product")ProductModel product, @PathVariable("id")Integer id) {
		System.out.println("r??ng------" + id);
		Products pro = this.productRepository.getOne(id);
		pro.setName(product.getName());
		pro.setImage(product.getImage());
		pro.setPrice(Integer.valueOf(product.getPrice()));
		pro.setQuantity(product.getQuantity());
		pro.setAvailable(1);
		Date now = new Date();
		pro.setCreated_date(now);
		pro.setCategory(this.categoryRepository.findByCateEqual(product.getCategory_id()));
		
		this.productRepository.save(pro);
		return "redirect:/admin/index_product";
	}
	
	@GetMapping("/admin/delete_product/{id}")
	public String delete(@PathVariable("id") Products pro) {
			this.productRepository.delete(pro);
		return "redirect:/admin/index_product";
	}
	
	
}
