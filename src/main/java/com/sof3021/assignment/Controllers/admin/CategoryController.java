package com.sof3021.assignment.Controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.CategoryModel;
import com.sof3021.assignment.entities.Categories;
import com.sof3021.assignment.reposories.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository cateRepository;
	
	@GetMapping("/admin/index_category")
	public String index(Model mol, @ModelAttribute("cate")CategoryModel cate) {
		List<Categories> ds = this.cateRepository.findAll();
		mol.addAttribute("ls", ds);
		
		mol.addAttribute("view", "/views/admin/CategoryIndex.jsp");
		return "admin/layoutAdmin";
	}

	@PostMapping("/admin/store_category")
	public String store(CategoryModel mol) {
		
		Categories cate = new Categories();
		cate.setName(mol.getName());
		
		System.out.println("-----------" + cate.getName() + "----------------");
		try {
			this.cateRepository.save(cate);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ngu");
		}
		
		
		return "redirect:/admin/index_category";
	}
	@PostMapping("/admin/update_category/{id}")
	public String update(CategoryModel category, @PathVariable("id")Integer id) {
		
		System.out.println(category.getName());
		
		Categories cate = new Categories();
		cate.setId(id);
		cate.setName(category.getName());
		
		this.cateRepository.save(cate);
		
		return "redirect:/admin/index_category";
	}
	
	
	@GetMapping("/admin/delete_category/{id}")
	public String delete(@PathVariable("id") Categories cate) {
			this.cateRepository.delete(cate);
		return "redirect:/admin/index_category";
	}
}
