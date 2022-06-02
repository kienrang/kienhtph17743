package com.sof3021.assignment.Controllers.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String index(Model mol) {
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
		od.setAcc(this.accountRepository.findByEmailUser(order.getEmail()));
		od.setAddress(order.getAddress());
		od.setActive(2);
		od.setCreate_date(new Date());
		this.orderRepository.save(od);
		List<Orders> odn = this.orderRepository.findByIdAcc(1);
		Orders oddb = odn.get(odn.size()-1);

		
		List<OrderDetails> oddtl = new ArrayList<>();

		
		for (Integer id : order.getProduct_id()) {
			OrderDetails o = new OrderDetails();
			o.setProducts(id);
			oddtl.add(o);
		}
		for (int i = 0; i < oddtl.size(); i++) {
			oddtl.get(i).setOrders(oddb);
			oddtl.get(i).setQuantity(order.getQuantity().get(i));
			int pro_price = this.productRepository.findByProductEqual(order.getProduct_id().get(i)).getPrice();
			int quantity = order.getQuantity().get(i);
			oddtl.get(i).setPrice(pro_price*quantity);
//			this.detailRepostory.save(oddtl.get(i));
		}
		this.detailRepostory.saveAll(oddtl);		
		return "redirect:/admin/index_order";
	}
	
	
}
