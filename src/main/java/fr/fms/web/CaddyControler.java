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

	@Autowired ArticleRepository articleRepository;
	IBusinessImpl iBusinessImpl = new IBusinessImpl();
	
	//List<Article> ListCaddy = caddy.;

	@GetMapping("/caddy") public String caddy(Model model) {
//		System.out.println(iBusinessImpl.listCaddy());
//		model.addAttribute("listCaddy", iBusinessImpl.listCaddy()); 
//		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		//model.addAllAttributes(ListCaddy);

		return "caddy"; 
	}

	@GetMapping("/addToCaddy")
	public String addToCaddy(Long id, Model model, @RequestParam(name="page", defaultValue = "0") int page,
									  @RequestParam(name="keyword", defaultValue = "") String keyword) {
		
		
		Article article = articleRepository.findById(id).get();
		iBusinessImpl.addToCaddy(article);
		return "redirect:/articles?page="+page+"&keyword="+keyword;

	}

	// lien de la page order
	@GetMapping("/order")
	public String order(Model model) {

		return "order";
	}

}
