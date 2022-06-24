package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {
	public List<Article> readAllArticles();
	public void addArticle(Article article);
	public void delArticle(Long i);
	public void updateArticle(Article article);
	public Article readArticleById(Long i);
	public Page<Article> readByDescriptionContains(String keyword, int page, int articlesByPage);
	public Page<Article> readAllArticlesByPage(int i);
	public List<Article> readArticleByCategory(Long i);
	
	public void addToCaddy (Article article);
	public void removeFromCaddy(Article article);
	
	public List<Category> readAllCategories();
	public void addCategory(Category category);
	public void delCategory(Long i);
	public void updateCategory(Category category);
	public Category readCategoryById(Long i);
}
