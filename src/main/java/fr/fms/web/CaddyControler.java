package fr.fms.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Controller
public class CaddyControler {
	
	  @Autowired ArticleRepository articleRepository;
	  
	  Map<Integer ,Article> caddy = null; 
	  List<Article> ListCaddy = null;
	  
	  @GetMapping("/caddy") public String caddy(Model model) {
	  
	  model.addAttribute("caddy", caddy); 
	  model.addAllAttributes(ListCaddy);
	  
	  return "caddy"; 
	  }
	  
	  @GetMapping("/addToCart")
		public String delete(Long id, int page, String keyword) {

			articleRepository.deleteById(id);

			return "redirect:/index?page="+page+"&keyword="+keyword;

		}
	 
}
