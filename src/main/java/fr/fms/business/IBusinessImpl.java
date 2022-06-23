package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

public class IBusinessImpl implements IBusiness {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Article> readAll() {
		return articleRepository.findAll();
	}

	@Override
	public Page<Article> readAllByPage(int i) {
		return articleRepository.findAll(PageRequest.of(i-1,5));
	}

	@Override
	public void addArticle(Article article) {
		articleRepository.save(article);
		
	}

	@Override
	public void delArticle(Long i) {
		articleRepository.deleteById(i);
		
	}

	@Override
	public void updateArticle(Article article) {
		articleRepository.save(article);
		
	}

	@Override
	public Article readArticleById(Long i) {
		return articleRepository.findById(i).get();
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void delCategory(Long i) {
		categoryRepository.deleteById(i);
		
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public Category readCategoryById(Long i) {
		return categoryRepository.findById(i).get();
	}

	@Override
	public List<Article> readArticleByCategory(Long i) {
		return articleRepository.findByCategoryId(i);	}

}