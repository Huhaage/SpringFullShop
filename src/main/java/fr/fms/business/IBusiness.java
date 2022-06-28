package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.User;

public interface IBusiness {
	public List<Article> readAllArticles();
	public void addArticle(Article article);
	public void delArticle(Long i);
	public void updateArticle(Article article);
	public Article readArticleById(Long i);
	public Page<Article> readByDescriptionContains(String keyword, int page, int articlesByPage);
	public Page<Article> readAllArticlesByPage(int i);
	public Page<Article> readArticlesByCategory(Long i,int page, int articlesByPage);
	
	public void addToCaddy (Long id);
	public int sizeCaddy();
	public void removeFromCaddy(Long id);
	public void saveOrder(Long idOrders);
	public Long newOrder(Long idCustomer);
	
	public List<Category> findAllCategories();
	public Page<Category> readAllCategories(int page,int categoriesByPages);
	public void addCategory(Category category);
	public void delCategory(Long i);
	public void updateCategory(Category category);
	public Category readCategoryById(Long i);
	
	public List<Customer> readAllCustomerByUser(User user);
}
