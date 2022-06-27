package fr.fms.web;


import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;

@Transactional
@Controller
public class CaddyControler {

	@Autowired
	IBusinessImpl iBusinessImpl;


	@GetMapping("/caddy")
	public String caddy(Model model, HttpSession session) {

		model.addAttribute("listCaddy", iBusinessImpl.listCaddy());
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		// pour le if
		model.addAttribute("size", iBusinessImpl.sizeCaddy());

		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);
		return "caddy";

	}

	@GetMapping("/addToCaddy")
	public String addToCaddy(Long id, Model model, @RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="keyword", defaultValue = "") String keyword) {
		iBusinessImpl.addToCaddy(id);	
		return "redirect:/articles?page="+page+"&keyword="+keyword;

	}

	
	@GetMapping("/delToCaddy")
	public String delToCaddy(Model model, Long id, HttpSession session) {
		iBusinessImpl.removeFromCaddy(id);
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy());
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		// pour le if
		model.addAttribute("size", iBusinessImpl.sizeCaddy());

		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);

		return "caddy";
	}

	@GetMapping("/clearCaddy")
	public String clearCaddy(Model model,HttpSession session) {
		iBusinessImpl.getCaddy().clear();
		// pour le if
		model.addAttribute("size", iBusinessImpl.sizeCaddy());

		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);
		return "redirect:/caddy";
	}

	// lien de la page order
	@GetMapping("/order")
	public String order(Model model) {
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy()); 
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		return "order";
	}
}
