package com.sof3021.assignment.Controllers.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.OrderModel;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.OrderDetails;
import com.sof3021.assignment.entities.Orders;
import com.sof3021.assignment.entities.Products;
import com.sof3021.assignment.reposories.OrderDetailRepostory;
import com.sof3021.assignment.reposories.OrderRepository;
import com.sof3021.assignment.reposories.ProductRepository;

@Controller
public class OrderUserController {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepostory detailRepostory;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("order_user")
	public String ordershow(Model mol, HttpServletRequest request ) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		List<Orders> ls = this.orderRepository.findByAccountAndActive(account.getEmail(), 1);
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
		mol.addAttribute("view", "/views/users/order.jsp");
		return "layout";
	}
	
	@GetMapping("orderDetail_user/{id}")
	public String ordershow1(Model mol, HttpServletRequest request,@PathVariable("id") Integer id) {
		List<Orders> ls = this.orderRepository.findByActive(1);
		List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(this.orderRepository.getOne(id));
		mol.addAttribute("lsoddl",lsoddl);
		mol.addAttribute("ls", ls);
		mol.addAttribute("view", "/views/users/order.jsp");
		return "layout";
	}
	
	@GetMapping("deleteOrder/{id}")
	public String deleteOrder(@PathVariable("id")Integer id) {
		Orders od = this.orderRepository.getOne(id);
		od.setActive(0);
		this.orderRepository.save(od);
		return "redirect:/order_user";
	}
	
	@GetMapping("/buynow/{id}")
	public String buynow(Model mol,@PathVariable("id")Integer id,@ModelAttribute("order")OrderModel model) {
		Products pro = this.productRepository.getOne(id);
		mol.addAttribute("pro", pro);
		mol.addAttribute("view", "/views/users/buynow.jsp");
		return "layout1";
	}
	
	@PostMapping("/buy/{id}")
	public String buy(@ModelAttribute("order")OrderModel order, @PathVariable("id")Integer id, HttpServletRequest request) {
		Products pr = this.productRepository.getOne(id);
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		Orders o = new Orders();
		o.setAcc(acc);
		o.setAddress(order.getAddress());
		o.setActive(1);
		o.setCreate_date(new Date());
		o.setPrice(pr.getPrice());
		this.orderRepository.save(o);
		List<Orders> odn = this.orderRepository.findByIdAcc(acc.getId());
		Orders oddb = odn.get(odn.size()-1);
		OrderDetails od = new OrderDetails();
		od.setPrice(pr.getPrice());
		od.setProducts(pr);
		od.setQuantity(1);
		od.setOrders(oddb);
		this.detailRepostory.save(od);
		
		
		
		return "redirect:/order_user";
	}
	
	
	@PostMapping("/store_order")
	public String store(@ModelAttribute("order")OrderModel order, HttpServletRequest request) {
		Orders od = new Orders();
		System.out.println("ché---------->" + order.toString());
		List<Integer> abc = order.getQuantity();
		for (Integer integer : abc) {
			if(integer == null) {
				abc.remove(integer);
			}
		}
		System.out.println("Ràng---------->" + order.toString());
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		System.out.println("Ché----->" + order.toString());
		od.setAcc(account);
		od.setAddress(order.getAddress());
		od.setActive(1);
		od.setCreate_date(new Date());
		this.orderRepository.save(od);
		List<Orders> odn = this.orderRepository.findByIdAcc(account.getId());
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
//			this.detailRepostory.save(oddtl.get(i));
			price += oddtl.get(i).getPrice();
		}
		od.setPrice(price);
		this.orderRepository.save(od);
		this.detailRepostory.saveAll(oddtl);		
		return "redirect:/index";
	}
}
