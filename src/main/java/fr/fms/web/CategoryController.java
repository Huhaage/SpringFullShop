/**
 * 
 */
package fr.fms.web;

import java.util.List;
import java.util.Optional;

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
public class CategoryController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping("/articlesByCategory")
    public String categoryArticles(Model model, Article article, Category category,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "1") Long id
           ) {
                                                                          
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

}
