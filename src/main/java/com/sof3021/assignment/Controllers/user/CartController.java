package com.sof3021.assignment.Controllers.user;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.OrderModel;
import com.sof3021.assignment.entities.OrderDetails;
import com.sof3021.assignment.entities.Orders;
import com.sof3021.assignment.entities.Products;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.Cart;
import com.sof3021.assignment.reposories.AccountRepository;
import com.sof3021.assignment.reposories.CartRepository;
import com.sof3021.assignment.reposories.OrderDetailRepostory;
import com.sof3021.assignment.reposories.OrderRepository;
import com.sof3021.assignment.reposories.ProductRepository;

@Controller
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("cart")
	public String Cart(Model mol, @ModelAttribute("order") OrderModel order, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		List<Cart> ls = this.cartRepository.findByCartAcc(acc);
		if(ls.size() <=0) {
			session.setAttribute("trong", "Không có sản phẩm trong giỏ hàng!");
		}else {
			mol.addAttribute("ls", ls);
		}
		mol.addAttribute("view", "/views/users/cart.jsp");
		return "layout";
	}
	
	@PostMapping("store_cart/{id}")
	public String store(@PathVariable("id") Integer id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		Products pro = this.productRepository.getOne(id);
		Cart c = new Cart();
		c.setProduct_id(pro);
		c.setUser(account);
		this.cartRepository.save(c);
		return "redirect:/cart";
	}
	
	@GetMapping("deleteCart/{id}")
	public String delete_cart(@PathVariable("id") Integer id) {
		Cart c = this.cartRepository.getOne(id);
		this.cartRepository.delete(c);
		return "redirect:/cart";
	}
}
