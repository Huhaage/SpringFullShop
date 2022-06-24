package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.OrderDetail;

public interface IBusiness {
	public List<Article> readAllArticles();
	public void addArticle(Article article);
	public void delArticle(Long i);
	public void updateArticle(Article article);
	public Article readArticleById(Long i);
	public Page<Article> readByDescriptionContains(String keyword, int page, int articlesByPage);
	public Page<Article> readAllArticlesByPage(int i);
<<<<<<< HEAD
	public List<Article> readArticleByCategory(Long i);
	
	public void addToCaddy (Long id);
	public void removeFromCaddy(Long id);
	
	public List<Category> readAllCategories();
=======
	public Page<Article> readArticlesByCategory(Long i,int page, int articlesByPage);
	
	public void addToCaddy (Long id);

	public void removeFromCaddy(Long id);
	
	public List<Category> findAllCategories();
	public Page<Category> readAllCategories(int page,int categoriesByPages);
>>>>>>> 68b31a1dbf76a106024a55277c95019075cec722
	public void addCategory(Category category);
	public void delCategory(Long i);
	public void updateCategory(Category category);
	public Category readCategoryById(Long i);
<<<<<<< HEAD
<<<<<<< HEAD
	public List<Article> readArticleByCategory(Long i);
	public List<OrderDetail> readAllOderDetail();
	public void addOrderDetail(OrderDetail oder);
=======
>>>>>>> 3e3c47e16b36a8448863489b3607dd367a0d3f77
=======
>>>>>>> 68b31a1dbf76a106024a55277c95019075cec722
}
