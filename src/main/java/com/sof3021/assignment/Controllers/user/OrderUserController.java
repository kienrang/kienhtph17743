package com.sof3021.assignment.Controllers.user;

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
import com.sof3021.assignment.reposories.OrderDetailRepostory;
import com.sof3021.assignment.reposories.OrderRepository;

@Controller
public class OrderUserController {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepostory detailRepostory;
	
	@GetMapping("order_user")
	public String ordershow(Model mol, HttpServletRequest request ) {
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
	@PostMapping("/store_order")
	public String store(@ModelAttribute("order")OrderModel order) {
		Orders od = new Orders();
		System.out.println("Ché----->" + order.toString());
//		od.setAcc(this.accountRepository.findByEmailUser(order.getEmail()));
//		od.setAddress(order.getAddress());
//		od.setActive(2);
//		od.setCreate_date(new Date());
//		this.orderRepository.save(od);
//		List<Orders> odn = this.orderRepository.findByIdAcc(1);
//		Orders oddb = odn.get(odn.size()-1);
//
//		
//		List<OrderDetails> oddtl = new ArrayList<>();
//
//		
//		for (Integer id : order.getProduct_id()) {
//			OrderDetails o = new OrderDetails();
//			o.setProducts(this.productRepository.getOne(id));
//			oddtl.add(o);
//		}
//		for (int i = 0; i < oddtl.size(); i++) {
//			oddtl.get(i).setOrders(oddb);
//			oddtl.get(i).setQuantity(order.getQuantity().get(i));
//			int pro_price = this.productRepository.findByProductEqual(order.getProduct_id().get(i)).getPrice();
//			int quantity = order.getQuantity().get(i);
//			oddtl.get(i).setPrice(pro_price*quantity);
////			this.detailRepostory.save(oddtl.get(i));
//		}
//		this.detailRepostory.saveAll(oddtl);		
		return "redirect:/index";
	}
}
