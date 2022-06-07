package com.sof3021.assignment.Controllers.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021.assignment.beans.OrderModel;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.OrderDetails;
import com.sof3021.assignment.entities.Orders;
import com.sof3021.assignment.entities.Products;
import com.sof3021.assignment.reposories.AccountRepository;
import com.sof3021.assignment.reposories.OrderDetailRepostory;
import com.sof3021.assignment.reposories.OrderRepository;
import com.sof3021.assignment.reposories.ProductRepository;
@Controller
public class OrderController {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepostory detailRepostory;
	
	@GetMapping("/admin/index_order")
	public String index(Model mol, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Orders> ls = this.orderRepository.findByActive(1);
		Orders o = new Orders();
		if(ls.size()<=0) {
			ls = null;
			session.setAttribute("trong", "Không có đơn hàng");
		}else {
			o = ls.get(0);
			List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(o);
			mol.addAttribute("lsoddl",lsoddl);
			mol.addAttribute("ls", ls);
		}
		
		mol.addAttribute("view", "/views/admin/OrderIndex.jsp");
		return "admin/layoutAdmin";
	}
	
	@GetMapping("/admin/create_order")
	public String create(Model mol, @ModelAttribute("order")OrderModel order) {
		List<Products> ls_pro = this.productRepository.findAll();
		
		mol.addAttribute("lspro", ls_pro);
		mol.addAttribute("view", "/views/admin/OrderCreate.jsp");
		return "admin/layoutAdmin";
	}
	
	
	@PostMapping("/admin/store_order")
	public String store(@ModelAttribute("order")OrderModel order) {
		Orders od = new Orders();
		System.out.println("ches-------------" + order.toString());
		od.setAcc(this.accountRepository.findByEmailUser(order.getEmail()));
		od.setAddress(order.getAddress());
		od.setActive(2);
		od.setCreate_date(new Date());
		this.orderRepository.save(od);
		
		List<Orders> odn = this.orderRepository.findByIdAcc(this.accountRepository.findByEmailUser(order.getEmail()).getId());
		Orders oddb = odn.get(odn.size()-1);

		
		
		List<OrderDetails> oddtl = new ArrayList<>();

		
		for (Integer id : order.getProduct_id()) {
			OrderDetails o = new OrderDetails();
			o.setProducts(this.productRepository.getOne(id));
			oddtl.add(o);
		}
		int price = 0;
		for (int i = 0; i < oddtl.size(); i++) {
			oddtl.get(i).setOrders(oddb);
			oddtl.get(i).setQuantity(order.getQuantity().get(i));
			int pro_price = this.productRepository.findByProductEqual(order.getProduct_id().get(i)).getPrice();
			int quantity = order.getQuantity().get(i);
			oddtl.get(i).setPrice(pro_price*quantity);
			price += oddtl.get(i).getPrice();
//			this.detailRepostory.save(oddtl.get(i));
		}
		od.setPrice(price);
		this.orderRepository.save(od);
		this.detailRepostory.saveAll(oddtl);		
		return "redirect:/admin/index_order";
	}
	
	@GetMapping("/admin/confirm_order/{id}")
	public String confirm(@PathVariable("id") Integer id) {
		Orders o = this.orderRepository.getOne(id);
		o.setActive(2);
		this.orderRepository.save(o);
		
		return "redirect:/admin/index_order";
	}
	@GetMapping("/admin/cancel_order/{id}")
	public String cancel(@PathVariable("id") Integer id) {
		Orders o = this.orderRepository.getOne(id);
		o.setActive(0);
		this.orderRepository.save(o);
		
		return "redirect:/admin/index_order";
	}
	
	@GetMapping("/admin/hoadon")
	public String hoadon(Model mol, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Orders> ls = this.orderRepository.findByActive(2);
		Orders o = new Orders();
		if(ls.size()<=0) {
			ls = null;
			session.setAttribute("trong", "Không có hóa đơn");
		}else {
			o = ls.get(0);
			List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(o);
			mol.addAttribute("lsoddl",lsoddl);
			mol.addAttribute("ls", ls);
		}
		
		mol.addAttribute("view", "/views/admin/hoadon.jsp");
		return "admin/layoutAdmin";
	}
	@GetMapping("/admin/hdct/{id}")
	public String hoadonct(Model mol,@PathVariable("id") Integer id) {
		List<Orders> ls = this.orderRepository.findByActive(2);
		List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(this.orderRepository.getOne(id));
		mol.addAttribute("lsoddl",lsoddl);
		mol.addAttribute("ls", ls);
		mol.addAttribute("view", "/views/admin/hdct.jsp");
		return "admin/layoutAdmin";
	}
	
	
}
