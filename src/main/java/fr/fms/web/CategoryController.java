/**
 * 
 */
package fr.fms.web;

import java.util.List;
import java.util.Optional;

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
public class CategoryController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // affiche les catégories coté admin
    @GetMapping("/adminListCategories")
    public String categories(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "1") Long id) {

        Page<Category> categories = categoryRepository.findAll(PageRequest.of(page, 4));
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

        Page<Article> articles = articleRepository.findByCategoryId(id, PageRequest.of(page, 6));
        Optional<Category> cat = categoryRepository.findById(id);
        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("listCategoryArticles", articles.getContent());
        model.addAttribute("listCategories", categories);
        model.addAttribute("pages", new int[articles.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", id);
        model.addAttribute("catName", cat.get().getDescription());
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

        categoryRepository.save(category);
        return "redirect:/adminListCategories";
    }

    // form edition category
    @GetMapping("/editCategory")
    public String editArticle(Model model, Long id, Category category) {

       Category cat = categoryRepository.findById(id).get();

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
        Optional<Category> cat = categoryRepository.findById(id);
        Category c = cat.get();
        if (c != null) {
            categoryRepository.save(category);
            return "redirect:/adminListCategories";
        }
        return "redirect:/adminListCategories";
    }
}
