package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Orders;
import fr.fms.entities.OrdersItem;
import fr.fms.entities.Users;

public interface IBusiness {

	/**
	 * Affiche les Article qui se trouve en base
	 * @return
	 */
	public List<Article> readAllArticles();

	/**
	 * Crée un Article en base
	 * @param article
	 */
	public void addArticle(Article article);

	/**
	 * Suprimer un Article qui se trouve en base
	 * @param i
	 */
	public void delArticle(Long i);

	/**
	 * Modifier un Article qui se trouve en base
	 * @param article
	 */
	public void updateArticle(Article article);

	/**
	 * Afficher un Article qui ce trouve en base en fonction de son ID
	 * @param i
	 * @return
	 */
	public Article readArticleById(Long i);

	/**
	 * Afficher tout les Article en Base dont en fonction du contenue de leur description
	 * @param keyword
	 * @param page
	 * @param articlesByPage
	 * @return
	 */
	public Page<Article> readByDescriptionContains(String keyword, int page, int articlesByPage);

	/**
	 * Affiche les Article en Page qui se trouve en base
	 * @param i
	 * @return
	 */
	public Page<Article> readAllArticlesByPage(int i);

	/**
	 * Afficher tout les Article d'une Categorie qui se trouve ne base
	 * @param i
	 * @param page
	 * @param articlesByPage
	 * @return
	 */
	public Page<Article> readArticlesByCategory(Long i,int page, int articlesByPage);

	/**
	 * Ajouter un Article au Caddy
	 * @param id
	 */
 	public void addToCaddy (Long id);

	 /**
	  * Suprimer un Article du Caddy
	  * @param id
	  */
	public void removeFromCaddy(Long id);

	/**
	 * Affichezr le nombre d'article qui se trouve dans le Panier
	 * @return
	 */
	public int sizeCaddy();

	/**
	 * enregistre les articles avec les ordersitem associés
	 * @param idOrders
	 */
	public void saveOrder(Long idOrders);

	/**
	 * créé une commande sans article
	 * @param idCustomer
	 * @return
	 */
	public Long newOrder(Long idCustomer);
	
	public Page<Orders> readAllOrders(int page, int ordersByPages);

	public List<OrdersItem> readAllItemsByOrderId(Long id);
	public Orders readOrderByid(Long id);

	/**
	 * Afficher toute les Categorie qui se trouve en Base
	 * @return
	 */
	public List<Category> findAllCategories();
	
	/**
	 * Afficher toute les Categori en base 
	 * @param page
	 * @param categoriesByPages
	 * @return
	 */
	public Page<Category> readAllCategories(int page,int categoriesByPages);

	/**
	 * Crée une Category en base
	 * @param category
	 */
	public void addCategory(Category category);

	/**
	 * Suprimer une Catégorie qui se trouve en base
	 * @param i
	 */
	public void delCategory(Long i);

	/**
	 * Suprimer une Catégorie qui se trouve en base
	 * @param category
	 */
	public void updateCategory(Category category);

	/**
	 * Afficher une Catégorie qui se trouve en bazse en fonction de son ID
	 * @param i
	 * @return
	 */
	public Category readCategoryById(Long i);
	
	/**
	 * Afficher tout les Customer en Base qui sont relier aux meme idUser
	 * @param idUser
	 * @return
	 */
	public List<Customer> readAllCustomerByUserId(Long idUser);

	/**
	 * Afficher tout les Customer en Base qui sont relier aux meme idUser
	 * @param idCustomer
	 * @return
	 */
	public Customer getCustomer(Long idCustomer);

	/**
	 * Afficher tout les Customer en Base qui sont relier aux meme idUser
	 * @param customer
	 */
	public void addCustomer(Customer customer);

	/**
	 * Afficher un user en base en fonction de son ID
	 * @param idUser
	 * @return
	 */
	public Users getUser(Long idUser);

	/**
	 * Affiche l'id d'un user en base en focrion de son mail
	 * @param mail
	 * @return
	 */
	public Long getIdUserByMail(String mail);
}
