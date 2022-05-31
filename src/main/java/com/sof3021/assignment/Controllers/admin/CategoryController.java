package com.sof3021.assignment.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.entities.Categories;

@Controller
public class CategoryController {
	
	
	@GetMapping("/admin/index_category")
	public String index(Model mol, @ModelAttribute("cate")Categories cate) {
		mol.addAttribute("view", "/views/admin/CategoryIndex.jsp");
		return "admin/layoutAdmin";
	}

	@PostMapping("/admin/store_category")
	public String store(@ModelAttribute("cate")Categories cate) {
		System.out.println("--vào store--");
		return "redirect:/admin/index_category";
	}
	@PostMapping("/admin/update_category")
	public String update(@ModelAttribute("cate")Categories cate) {
		System.out.println("--vào update--");
		return "redirect:/admin/index_category";
	}
	@GetMapping("/admin/delete_category")
	public String delete(@ModelAttribute("cate")Categories cate) {
		System.out.println("--vào delete--");
		return "redirect:/admin/index_category";
	}
}
