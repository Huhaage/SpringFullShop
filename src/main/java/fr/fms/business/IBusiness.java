package fr.fms.business;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {
	public List<Article> readAll();
	public Page<Article> readAllByPage(int i);
	public void addArticle(Article article);
	public void delArticle(Long i);
	public void updateArticle(Article article);
	public Article readArticleById(Long i);
	public void addCategory(Category category);
	public void delCategory(Long i);
	public void updateCategory(Category category);
	public Category readCategoryById(Long i);
	public List<Article> readArticleByCategory(Long i);
}
