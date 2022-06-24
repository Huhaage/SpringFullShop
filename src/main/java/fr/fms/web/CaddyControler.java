package fr.fms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Transactional
@Controller
public class CaddyControler {

	@Autowired
	IBusinessImpl iBusinessImpl;

<<<<<<< HEAD
	@GetMapping("/caddy")
	public String caddy(Model model) {
		// System.out.println(iBusinessImpl.listCaddy());
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy());
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		// model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		// model.addAllAttributes(ListCaddy);
		System.out.println(iBusinessImpl.totalCaddy());
		return "caddy";
	}

	@GetMapping("/addToCaddy")
	public String addToCaddy(Long id, Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {

		iBusinessImpl.addToCaddy(id);

		return "redirect:/articles?page=" + page + "&keyword=" + keyword;
=======
	@GetMapping("/caddy") public String caddy(Model model) {
		//		System.out.println(iBusinessImpl.listCaddy());
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy()); 
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		
		return "caddy"; 
	}

	@GetMapping("/addToCaddy")
	public String addToCaddy(Long id, Model model, @RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="keyword", defaultValue = "") String keyword) {
		iBusinessImpl.addToCaddy(id);	
		return "redirect:/articles?page="+page+"&keyword="+keyword;
>>>>>>> christophe

	}

	@GetMapping("/delToCaddy")
	public String delToCaddy(Model model, Long id) {
		iBusinessImpl.removeFromCaddy(id);
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy());
		return "caddy";
	}

	@GetMapping("/clearCaddy")
	public String clearCaddy() {
		iBusinessImpl.getCaddy().clear();

		return "redirect:/home";
	}

	// lien de la page order
	@GetMapping("/order")
	public String order(Model model) {
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy()); 
		return "order";
	}
}
