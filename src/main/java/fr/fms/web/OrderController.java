package fr.fms.web;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Orders;


@Controller
public class OrderController {
	@Autowired
	private IBusinessImpl business;
	
	@Transactional
	@GetMapping("/readOrders")
	public String readOrders(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		Page<Orders> orders = business.readAllOrders(page, 6);
		model.addAttribute("listOrders", orders.getContent());
		return "redirect:/readOrders";	
	}
}
 