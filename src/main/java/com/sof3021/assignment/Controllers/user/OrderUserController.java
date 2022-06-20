package com.sof3021.assignment.Controllers.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sof3021.assignment.beans.OrderModel;
import com.sof3021.assignment.beans.Quantity;
import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.Cart;
import com.sof3021.assignment.entities.OrderDetails;
import com.sof3021.assignment.entities.Orders;
import com.sof3021.assignment.entities.Products;
import com.sof3021.assignment.reposories.CartRepository;
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
	@Autowired
	private CartRepository cartRepository;

	@GetMapping("order_user")
	public String ordershow(Model mol, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		List<Orders> ls = this.orderRepository.findByAccountAndActive(account.getEmail(), 1);
		Orders o = new Orders();
		if (ls.size() <= 0) {
			ls = null;
			session.setAttribute("trong", "Không có đơn hàng");
		} else {
			o = ls.get(0);
			List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(o);
			mol.addAttribute("lsoddl", lsoddl);
			mol.addAttribute("ls", ls);
		}
		mol.addAttribute("view", "/views/users/order.jsp");
		return "layout";
	}

	@GetMapping("orderedit_user/{id}")
	public String orderedit(Model mol, @PathVariable Integer id,@ModelAttribute("quantity") Quantity quantity ) {
		Orders ls = this.orderRepository.getOne(id);
		List<Products> lspro =  this.productRepository.findAll();
		List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(ls);
		mol.addAttribute("order", new OrderModel());
		mol.addAttribute("lsoddl", lsoddl);
		mol.addAttribute("o", ls);
		mol.addAttribute("lspro", lspro);
		mol.addAttribute("view", "/views/users/order_edit.jsp");
		return "layout1";
	}
	@PostMapping("orderupdate_user/{id}")
	public String orderupdate(Model mol, HttpServletRequest request, @PathVariable Integer id, @ModelAttribute OrderModel order ) {
		Orders od = this.orderRepository.getOne(id);
		List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(od);
		for (int i = 0; i < order.getProduct_id().size(); i++) {
			OrderDetails o = new OrderDetails();
			o.setOrders(od);
			o.setProducts(this.productRepository.getOne(order.getProduct_id().get(i)));
			o.setQuantity(order.getQuantity().get(i));
			int price = this.productRepository.getOne(order.getProduct_id().get(i)).getPrice() * order.getQuantity().get(i);
			o.setPrice(price);
			lsoddl.add(o);
			this.detailRepostory.save(o);
		}
		int price = 0;
		for (OrderDetails orderDetails : lsoddl) {
			 price += orderDetails.getPrice();
		}
		od.setPrice(price);
		od.setAddress(order.getAddress());
		this.orderRepository.save(od);
		return "redirect:/order_user";
	}
	@PostMapping("updateorderdetails/{id}")
	public String orderdetailupdate(Model mol, HttpServletRequest request, @PathVariable Integer id, @ModelAttribute Quantity quantity) {
		OrderDetails od = this.detailRepostory.getOne(id);
		od.setQuantity(quantity.getSoluong());
		od.setPrice(od.getProducts().getPrice() * od.getQuantity());
		this.detailRepostory.save(od);
		
		List<OrderDetails> ls = this.detailRepostory.findByOrder_id(od.getOrders());
		int price = 0;
		for (OrderDetails orderDetails : ls) {
			 price += orderDetails.getPrice();
		}
		Orders o = this.orderRepository.findByIdOder(od.getOrders().getId());
		o.setPrice(price);
		this.orderRepository.save(o);
		return "redirect:/orderedit_user/" + o.getId();
	}

	@GetMapping("orderDetail_user/{id}")
	public String ordershow1(Model mol, HttpServletRequest request, @PathVariable("id") Integer id) {
		List<Orders> ls = this.orderRepository.findByActive(1);
		List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(this.orderRepository.getOne(id));
		mol.addAttribute("lsoddl", lsoddl);
		mol.addAttribute("ls", ls);
		mol.addAttribute("view", "/views/users/order1.jsp");
		return "layout1";
	}

	@GetMapping("deleteOrder/{id}")
	public String deleteOrder(@PathVariable("id") Integer id) {
		Orders od = this.orderRepository.getOne(id);
		od.setActive(0);
		this.orderRepository.save(od);
		return "redirect:/order_user";
	}

	@GetMapping("/buynow/{id}")
	public String buynow(Model mol, @PathVariable("id") Integer id, @ModelAttribute("order") OrderModel model) {
		Products pro = this.productRepository.getOne(id);
		mol.addAttribute("pro", pro);
		mol.addAttribute("view", "/views/users/buynow.jsp");
		return "layout1";
	}

	@PostMapping("/buy/{id}")
	public String buy(@ModelAttribute("order") OrderModel order, @PathVariable("id") Integer id,
			HttpServletRequest request) {
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
		Orders oddb = odn.get(odn.size() - 1);
		OrderDetails od = new OrderDetails();
		od.setPrice(pr.getPrice() * order.getQuantity().get(0));
		od.setProducts(pr);
		od.setQuantity(order.getQuantity().get(0));
		od.setOrders(oddb);

		oddb.setPrice(pr.getPrice() * order.getQuantity().get(0));
		this.orderRepository.save(oddb);
		this.detailRepostory.save(od);

		return "redirect:/order_user";
	}

	@PostMapping("/store_order")
	public String store(@ModelAttribute("order") OrderModel order, HttpServletRequest request) {
		Orders od = new Orders();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		od.setAcc(account);
		od.setAddress(order.getAddress());
		od.setActive(1);
		od.setCreate_date(new Date());
		this.orderRepository.save(od);
		List<Orders> odn = this.orderRepository.findByIdAcc(account.getId());
		Orders oddb = odn.get(odn.size() - 1);
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
			oddtl.get(i).setPrice(pro_price * quantity);
			price += oddtl.get(i).getPrice();
		}
		od.setPrice(price);
		this.orderRepository.save(od);
		this.detailRepostory.saveAll(oddtl);
		List<Cart> cart = this.cartRepository.findByCartAcc(account);
		for (Cart cart2: cart) {
			this.cartRepository.delete(cart2);
		}
		return "redirect:/index";
	}

	@GetMapping("/history")
	public String history(Model mol, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		List<Orders> ls = this.orderRepository.findByAccountAndActive(account.getEmail(), 2);
		Orders o = new Orders();
		if (ls.size() <= 0) {
			ls = null;
			session.setAttribute("trong", "Không có đơn hàng đã mua");
		} else {
			o = ls.get(0);
			List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(o);
			mol.addAttribute("lsoddl", lsoddl);
			mol.addAttribute("ls", ls);
		}
		mol.addAttribute("view", "/views/users/history.jsp");
		return "layout";
	}

	@GetMapping("/history_detail/{id}")
	public String history_detail(Model mol, HttpServletRequest request, @PathVariable("id") Integer id) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		List<Orders> ls = this.orderRepository.findByAccountAndActive(account.getEmail(), 2);
		Orders o = new Orders();
		if (ls.size() <= 0) {
			ls = null;
			session.setAttribute("trong", "Không có đơn hàng đã mua");
		} else {
			o = this.orderRepository.getOne(id);
			List<OrderDetails> lsoddl = this.detailRepostory.findByOrder_id(o);
			mol.addAttribute("lsoddl", lsoddl);
			mol.addAttribute("ls", ls);
		}
		mol.addAttribute("view", "/views/users/history.jsp");
		return "layout";
	}
}
