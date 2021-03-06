package fr.fms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.dao.CustomerRepository;
import fr.fms.dao.OrdersItemRepository;
import fr.fms.dao.OrdersRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Orders;
import fr.fms.entities.OrdersItem;

import fr.fms.entities.Users;

@Service
public class IBusinessImpl implements IBusiness {
	private Map<Long, Article> caddy = new HashMap<Long, Article>();
	private double total;

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrdersRepository orderRepository;

	@Autowired
	private OrdersItemRepository orderItemRepository;

	public Map<Long, Article> getCaddy() {
		return caddy;
	}

	public List<Article> listCaddy() {
		return caddy.values().stream().collect(Collectors.toCollection(ArrayList::new));
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
		return articleRepository.findAll(PageRequest.of(i - 1, 5));
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
	public Page<Article> readArticlesByCategory(Long i, int page, int articlesByPage) {
		return articleRepository.findByCategoryId(i, PageRequest.of(page, articlesByPage));
	}

	@Override
	public void addToCaddy(Long id) {
		if (caddy.containsKey(id)) {

			Article article = caddy.get(id);
			caddy.get(article.getId()).setQuantity(article.getQuantity() + 1);

		} else {
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
	public Page<Category> readAllCategories(int page, int categoriesByPages) {
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

	// cr???? une commande sans article
	@Override
	public Long newOrder(Long idCustomer) {

		Long idOrder = 0L;
		List<Orders> lastOrder = null;
		if (customerRepository.findById(idCustomer) != null) {
			double total = totalCaddy();
			Orders order = new Orders(null, customerRepository.findById(idCustomer).get(), new Date(), total);
			orderRepository.save(order);
			lastOrder = orderRepository.findAllByCustomerOrderByDateDesc(customerRepository.findById(idCustomer).get());
		}
		return lastOrder.get(0).getOrderId();

	}

	// enregistre les articles avec les ordersitem associ??s
	@Override
	public void saveOrder(Long idOrder) {

		caddy.values().forEach((a) -> orderItemRepository
				.save(new OrdersItem(orderRepository.findById(idOrder).get(), a, a.getQuantity())));

	}

	@Override
	public List<Customer> readAllCustomerByUserId(Long idUser) {
		return customerRepository.findAllCustomerByUserId(idUser);
	}

	@Override
	public Customer getCustomer(Long idCustomer) {

		// test si id foireux passer dans l'url, comme ??a pour voir...
		Optional  <Customer> cust =customerRepository.findById(idCustomer);
		if (cust.isPresent() ) {
			return cust.get();
		}
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Users getUser(Long idUser) {
		return userRepository.findById(idUser).get();
	}

	@Override
	public Long getIdUserByMail(String mail) {
		Users userReceived = userRepository.findByMail(mail);
		Users user = new Users(userReceived.getId(), userReceived.getMail(), userReceived.getPassword(),
				userReceived.getActive());

		return user.getId();
	}
	
	public Article getArticleById(long id) {
		return articleRepository.findById(id).get();
	}

	@Override
	public Page<Orders> readAllOrders(int page, int ordersByPages) {
		
		return orderRepository.findAll(PageRequest.of(page, ordersByPages));
	}

	
	//Methods tests
	public String great() {
		return "Hello World";
	}

	@Override

	public List<OrdersItem> readAllItemsByOrderId(Long id) {

		return orderItemRepository.findAllOrdersItemsByOrdersOrderId(id);

	}

	@Override

	public Orders readOrderByid(Long id) {

		return orderRepository.findById(id).get();

	}
}