package fr.fms.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Service
public class IBusinessImpl implements IBusiness {
	private Map<Long ,Article> caddy = new HashMap<Long ,Article>(); 
	private double total;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Map<Long ,Article> getCaddy(){
		return caddy;
	}
	public List<Article> listCaddy(){
		return caddy.values().stream().collect(	Collectors.toCollection(ArrayList::new));
	}
	 
	public double totalCaddy() {
		this.total = 0.0;
		caddy.values().forEach((a) -> this.total += a.getPrice() * a.getQuantity()); 
		return this.total;
	}
	
	@Override
	public List<Article> readAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Page<Article> readAllArticlesByPage(int i) {
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
	public Page<Article> readArticlesByCategory(Long i,int page, int articlesByPage) {
		return articleRepository.findByCategoryId(i, PageRequest.of(page, articlesByPage));
	}

	@Override
	public void addToCaddy(Long id) {
		
		if(caddy.containsKey(id)) {
			Article article = caddy.get(id);
			caddy.get(article.getId()).setQuantity(article.getQuantity()+1);
			
			}else{
				caddy.put(id, articleRepository.findById(id).get());
			}
		
	}

	@Override
	public void removeFromCaddy(Long id) {
		int quantity = caddy.get(id).getQuantity() - 1;
		if (0 < quantity) {
			caddy.get(id).setQuantity(quantity);
		} else
			caddy.remove(id);
		
	}
	
	@Override
	public int sizeCaddy() {
		return caddy.size();
	}
	
	@Override
	public Page<Category> readAllCategories(int page,int categoriesByPages) {
		return categoryRepository.findAll(PageRequest.of(page, categoriesByPages));
	}
	
	@Override
	public Page<Article> readByDescriptionContains(String keyword, int page, int articlesByPage) {
		return articleRepository.findByDescriptionContains(keyword, PageRequest.of(page, articlesByPage));
	}
	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
}