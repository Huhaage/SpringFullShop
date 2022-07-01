/**
 * 
 */
package fr.fms.web;

import java.util.List;
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
import fr.fms.services.GlobalException;

/**
 * @author CHJCS
 *
 */

@Controller
public class CategoryController {

    @Autowired
    IBusinessImpl iBusinessImpl;

    // affiche les catégories coté admin
    @GetMapping("/adminListCategories")
    public String categories(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "1") Long id) {

        // Page<Category> categories = categoryRepository.findAll();
        Page<Category> categories = iBusinessImpl.readAllCategories(page, 4);
        if (categories.isEmpty()) {
            throw new GlobalException("Aucune données");
        }
        model.addAttribute("listCategories", categories.getContent());
        model.addAttribute("pages", new int[categories.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", id);
        return "adminListCategories";
    }

    // affiche les articles par catégorie
    @GetMapping("/articlesByCategory")
    public String categoryArticles(Model model, Article article, Category category,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "1") Long id) {

        Page<Article> articles = iBusinessImpl.readArticlesByCategory(id, page, 6);
        if (articles.isEmpty()) {
            throw new GlobalException("Aucune données");
        }
        Category cat = iBusinessImpl.readCategoryById(id);
        if (cat==null) {
            throw new GlobalException("Aucunes categories");
        }
        List<Category> categories = iBusinessImpl.findAllCategories();

        model.addAttribute("listCategoryArticles", articles.getContent());
        model.addAttribute("listCategories", categories);
        model.addAttribute("pages", new int[articles.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", id);
        model.addAttribute("catName", cat.getDescription());
        return "articlesByCategory";
    }

    // lien vers la page ajout category
    @GetMapping("/addCategory")
    public String addCategory(Model model, Category category) {

        return "addCategory";
    }

    // ajoute en base et retourne la page adminClistcategory
    @PostMapping("/saveCategory")
    public String saveCategory(Model model, @Valid Category category, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addCategory";
        }

       iBusinessImpl.addCategory(category);
        return "redirect:/adminListCategories";
    }

    // form edition category
    @GetMapping("/editCategory")
    public String editArticle(Model model, Long id, Category category) {

        Category cat = iBusinessImpl.readCategoryById(id);
        if (cat==null) {
            throw new GlobalException("categorie inexistante");
        }
        model.addAttribute("category", cat);
        model.addAttribute("idCat", cat.getId());
        model.addAttribute("imgCat", cat.getImgUrl());
        return "editCategory";
    }

    // retourne formulaire ajout d'un article
    @PostMapping("/updateCategory")
    public String updateArticle(Model model, @Valid Category category, BindingResult bindingResult,
            @RequestParam(value = "id") Long id) {
        if (bindingResult.hasErrors()) {
            return "editCategory";
        }
        Category cat = iBusinessImpl.readCategoryById(id);
      
        if (cat != null) {
           iBusinessImpl.addCategory(category);
            return "redirect:/adminListCategories";
        }
        return "redirect:/adminListCategories";
    }
}
