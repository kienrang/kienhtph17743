package com.sof3021.assignment.Controllers.admin;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021.assignment.entities.Account;
import com.sof3021.assignment.entities.OrderDetails;
import com.sof3021.assignment.entities.Orders;
import com.sof3021.assignment.reposories.OrderDetailRepostory;
import com.sof3021.assignment.reposories.OrderRepository;

@Controller
public class AdminIndex {
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("admin/index")
	public String HomeShow(Model mol, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		System.out.println("ché ---------->" + acc.toString());
		mol.addAttribute("view", "/views/admin/index.jsp");
		return "admin/layoutAdmin";
	}
	@GetMapping("admin/doanhthu")
	public String doanhthu(Model mol, HttpServletRequest request, @RequestParam("p") Optional<Integer> p) {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		List<Orders> ls = this.orderRepository.findByActive(2);
		
		Pageable pageable = PageRequest.of(p.orElse(0), 2);
		Page<Orders> page= this.orderRepository.findAll(pageable);
		Page<Orders> pages = new PageImpl<Orders>(ls, pageable, ls.size());
		if(ls.size()<=0) {
			ls = null;
			session.setAttribute("trong", "Không có hóa đơn");
		}else {
			mol.addAttribute("ls", pages);
		}
		int tong = 0;
		for(int i = 0; i < ls.size(); i++) {
			tong += ls.get(i).getPrice();
		}
		
		mol.addAttribute("tien", tong);
		mol.addAttribute("view", "/views/admin/doanhthu.jsp");
		return "admin/layoutAdmin";
	}
	
}
