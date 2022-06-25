/**
 * 
 */
package fr.fms.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

/**
 * @author CHJCS
 *
 */
@Controller
public class ArticleController {
	//IIBusinessImplImpl IBusinessImpl = new IIBusinessImplImpl();
	
	@Autowired
	IBusinessImpl iBusinessImpl;
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping("/")
	public String accueil(HttpSession session) {
		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);
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

		List<Category> categories = iBusinessImpl.findAllCategories();
		model.addAttribute("listCategories", categories);

		return "addArticle";
	}

	// ajoute en base et retourne la page articles
	@PostMapping("/save")
	public String save(Model model, @Valid Article article, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Category> categories = iBusinessImpl.findAllCategories();
			model.addAttribute("listCategories", categories);
			return "addArticle";
		}

		iBusinessImpl.addArticle(article);
		return "redirect:/articles";
	}

	//lien vers la page articles
	@GetMapping("/articles")
	public String articles(Model model, @RequestParam(name="page", defaultValue = "0") int page,
										@RequestParam(name="keyword", defaultValue = "") String kw,
										HttpSession session) {
		Page<Article> articles = iBusinessImpl.readByDescriptionContains(kw, page, 6); //récup tous les articles
		List<Category> categories = iBusinessImpl.findAllCategories();
		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);
		
		model.addAttribute("listArticle", articles.getContent()); //insert les articles dans le model
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", kw);
			
		model.addAttribute("listCategories", categories);
		
		return "articles"; //cette méthode retourne au dispacterServlet une vue
	}
	

	//lien admin pour afficher la list des articles avec la possibilité de modifier/supprimer
	@GetMapping("/adminListArticles")
	public String articlesAdmin(Model model, @RequestParam(name="page", defaultValue = "0") int page,
										@RequestParam(name="keyword", defaultValue = "") String kw) {
		Page<Article> articles = iBusinessImpl.readByDescriptionContains(kw, page, 6); //récup tous les articles
		
		model.addAttribute("listArticle", articles.getContent()); //insert les articles dans le model
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", kw);
				
		return "adminListArticles"; //cette méthode retourne au dispacterServlet une vue
	}
	
	@GetMapping("/delete")
	public  String delete(Long id, int page, String keyword) {
		iBusinessImpl.delArticle(id);
		
		return "redirect:/adminListArticles?page=" + page + "&keyword=" + keyword;
	}
	
	@PostMapping("/updateArticle")
	public String updateArticle(Article article, BindingResult bindingResult){
		if(bindingResult.hasErrors()) return "adminListArticles";

		if(article.getId() != null) {
			iBusinessImpl.updateArticle(article);
		}
		
		return "redirect:/adminListArticles";
	}
	
	@GetMapping("/editArticle")
	public String editArticle(Model model, @Valid Long id){		
		Article articleToEdit = iBusinessImpl.readArticleById(id);
		model.addAttribute("articleToEdit", articleToEdit);
		
		List<Category> categories = iBusinessImpl.findAllCategories();
		model.addAttribute("listCategories", categories);
		
		return "editArticle";
	}


}
