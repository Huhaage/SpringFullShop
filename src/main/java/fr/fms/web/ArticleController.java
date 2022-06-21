/**
 * 
 */
package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

/**
 * @author CHJCS
 *
 */
@Controller
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/home")
	public String home() {	
		return "home";
	}
	
	@GetMapping("/")
	public String accueil() {	
		return "home";
	}
	
	//lien vers la liste des formations
	@GetMapping("/articles")
	public String articles(Model model, @RequestParam(name="page", defaultValue = "0") int page,
										@RequestParam(name="keyword", defaultValue = "") String kw) {
		Page<Article> articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5)); //récup tous les articles
		List<Category> categories = categoryRepository.findAll();
		
//		model.addAttribute("listArticle", articles.getContent()); //insert les articles dans le model
//		model.addAttribute("pages", new int[articles.getTotalPages()]);
//		model.addAttribute("currentPage", page);
//		model.addAttribute("keyword", kw);
//		
//		model.addAttribute("listCategories", categories);
		
		return "articles"; //cette méthode retourne au dispacterServlet une vue
	}
}
