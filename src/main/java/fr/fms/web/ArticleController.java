/**
 * 
 */
package fr.fms.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//lien vers la page 403    //// test
	@GetMapping("/403")
	public String error() {
		return "403";
	}
	
	// lien vers la page admin
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	// lien vers la page ajout article
	@GetMapping("/addArticle")
	public String addArticle(Model model, Article article) {

		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("listCategories", categories);

		return "addArticle";
	}

	// ajoute en base et retourne la page articles
	@PostMapping("/save")
	public String save(Model model, @Valid Article article, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Category> categories = categoryRepository.findAll();
			model.addAttribute("listCategories", categories);
			return "addArticle";
		}

		articleRepository.save(article);
		return "redirect:/articles";
	}

	//lien vers la page articles
	@GetMapping("/articles")
	public String articles(Model model, @RequestParam(name="page", defaultValue = "0") int page,
										@RequestParam(name="keyword", defaultValue = "") String kw) {
		Page<Article> articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 6)); //récup tous les articles
		List<Category> categories = categoryRepository.findAll();
		
		
		model.addAttribute("listArticle", articles.getContent()); //insert les articles dans le model
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", kw);
			
		model.addAttribute("listCategory", categories);
		
		return "articles"; //cette méthode retourne au dispacterServlet une vue
	}
}
