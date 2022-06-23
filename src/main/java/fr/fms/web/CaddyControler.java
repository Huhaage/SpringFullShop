package fr.fms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Controller
public class CaddyControler {

	@Autowired ArticleRepository articleRepository;

	Map<Long ,Article> caddy = new HashMap<Long ,Article>(); 
	//List<Article> ListCaddy = caddy.;

	@GetMapping("/caddy") public String caddy(Model model) {	  
		model.addAttribute("caddy", caddy); 
		//model.addAllAttributes(ListCaddy);

		return "caddy"; 
	}

	@GetMapping("/addToCaddy")
	public String addToCaddy(Long id, Model model, @RequestParam(name="page", defaultValue = "0") int page,
									  @RequestParam(name="keyword", defaultValue = "") String keyword) {
		System.out.println("id :" + id);
		
		Article article = articleRepository.findById(id).get();
		
		caddy.put(article.getId(), article) ;
		System.out.println(caddy.get(id).getBrand());
		

		return "redirect:/articles?page="+page+"&keyword="+keyword;

	}

	// lien de la page order
	@GetMapping("/order")
	public String order(Model model) {

		return "order";
	}

}
