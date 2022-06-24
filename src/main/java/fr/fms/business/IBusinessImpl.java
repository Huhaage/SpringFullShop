package fr.fms.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.dao.OrderDetailRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.OrderDetail;

@Service
public class IBusinessImpl implements IBusiness {
	private Map<Long ,Article> caddy = new HashMap<Long ,Article>(); 
	private double total;
	
	
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	public Map<Long ,Article> getCaddy(){
		return caddy;
	}
	public List<Article> listCaddy(){
		return caddy.values().stream().collect(	Collectors.toCollection(ArrayList::new));
		
	}
	 
	public double totalCaddy() {
		
		caddy.values().forEach((a) -> total += a.getPrice() * a.getQuantity()); 
		return 0;
		
	}
	
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

	@Override
	public void addToCaddy(Article article) {
		if(caddy.containsKey(article.getId())) {
			
			caddy.get(article.getId()).setQuantity(article.getQuantity()+1);
			
			}else{
				caddy.put(article.getId(), article);
			}
		
	}

	@Override
	public void removeFromCaddy(Article article) {
		int quantity = article.getQuantity()-1;
		if(0 < quantity) {
			caddy.get(article.getId()).setQuantity(article.getQuantity()-1);
		}
		else caddy.remove(article.getId());
		
	}
	@Override
	public List<OrderDetail> readAllOderDetail() {
		return orderDetailRepository.findAll();
	}
	@Override
	public void addOrderDetail(OrderDetail order) {
		orderDetailRepository.save(order);
		
	}

}