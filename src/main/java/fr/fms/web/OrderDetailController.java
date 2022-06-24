package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.OrderDetail;
import groovyjarjarpicocli.CommandLine.Model;

public class OrderDetailController {
	@Autowired
	IBusinessImpl businessImpl;
	
	@GetMapping("/Order")
	public String validOrder(Model model) {
		return "Order";
		
	}
	
	@GetMapping("/addOrderDetail")
		public String addOrder(Model model, OrderDetail order) {
			businessImpl.readAllOderDetail();
		return "addOrderDetail";
	}
	
	@GetMapping("/orderDetails")
	public String orderDetails(Model model, @RequestParam(name="page", defaultValue = "0") int page,
										@RequestParam(name="keyword", defaultValue = "") String kw) {
		List<OrderDetail> orderDetails = businessImpl.readAllOderDetail(); 
		
		return "orderDetails"; 
	}
}
