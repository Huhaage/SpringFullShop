package fr.fms;

import javax.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;

import fr.fms.dao.CustomerRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;


import fr.fms.entities.Users;


@Transactional
@SpringBootApplication
public class SpringFullShopApplication implements CommandLineRunner {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CustomerRepository customerRipository;
	
	@Autowired
	UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringFullShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		

//		 Category smartphone = categoryRepository.save(new Category(null,"Smartphone","smartphone.jpg",null));
//         Category tablet = categoryRepository.save(new Category(null,"Tablet","tablet.jpg",null)); 
//         Category pc = categoryRepository.save(new Category(null,"PC","portable.jpg",null));
//		 Category logiciel = categoryRepository.save(new Category(null,"Logiciel","office.jpg",null));
//		
//		 articleRepository.save(new Article(null,"S8","SamSung",350,"smartphone.jpg",smartphone, 1));
//		 articleRepository.save(new Article(null,"S10","SamSung",400,"smartphone.jpg",smartphone, 1));
//		 articleRepository.save(new Article(null,"S11","SamSung",420,"smartphone.jpg",smartphone, 1));
//		 articleRepository.save(new Article(null,"SE","iPhone",650,"smartphone.jpg",smartphone,1));
//		 articleRepository.save(new Article(null,"Redmi Go","Xiaomi",200,"smartphone.jpg",smartphone,1));
//		 articleRepository.save(new Article(null,"Mate X","Huawei",180,"smartphone.jpg",smartphone,1));
//		 articleRepository.save(new Article(null,"Redmi9A","Xiaomi",150,"smartphone.jpg",smartphone,1));
//		
//		 articleRepository.save(new Article(null,"Predator PO3","Acer",1899.99,"portable.jpg",pc,1));
//		 articleRepository.save(new Article(null,"SK15","Skillkorp",1199.99,"portable.jpg",pc,1));
//		 articleRepository.save(new Article(null,"Omen GT21","HP",1599.99,"portable.jpg",pc,1));
//		 articleRepository.save(new Article(null,"SK16","Skillkorp",899.99,"portable.jpg",pc,1));
//		 articleRepository.save(new Article(null,"GT22","HP",4299,"portable.jpg",pc,1));
//		 articleRepository.save(new Article(null,"Predator PO7","Acer",2699.99,"portable.jpg",pc,1));
//		
//		 articleRepository.save(new Article(null,"S8","SamSung",350,"unknown.png",smartphone, 1));
//		 articleRepository.save(new Article(null,"S10","SamSung",400,"unknown.png",smartphone, 1));
//		 articleRepository.save(new Article(null,"S11","SamSung",420,"unknown.png",smartphone, 1));
//		 articleRepository.save(new Article(null,"SE","iPhone",650,"unknown.png",smartphone,1));
//		 articleRepository.save(new Article(null,"Redmi Go","Xiaomi",200,"unknown.png",smartphone,1));
//		 articleRepository.save(new Article(null,"Mate X","Huawei",180,"unknown.png",smartphone,1));
//		 articleRepository.save(new Article(null,"Redmi9A","Xiaomi",150,"unknown.png",smartphone,1));
//		
//		 articleRepository.save(new Article(null,"Predator PO3","Acer",1899.99,"unknown.png",pc,1));
//		 articleRepository.save(new Article(null,"SK15","Skillkorp",1199.99,"unknown.png",pc,1));
//		 articleRepository.save(new Article(null,"Omen GT21","HP",1599.99,"unknown.png",pc,1));
//		 articleRepository.save(new Article(null,"SK16","Skillkorp",899.99,"unknown.png",pc,1));
//		 articleRepository.save(new Article(null,"GT22","HP",4299,"unknown.png",pc,1));
//		 articleRepository.save(new Article(null,"Predator PO7","Acer",2699.99,"unknown.png",pc,1));
//
//		 articleRepository.save(new Article(null,"TAB M10","Lenovo",299.99,"tablet.jpg",tablet,1));
//		 articleRepository.save(new Article(null,"Galaxy Tab A7","Samsung",179,"tablet.jpg",tablet,1));
//		 articleRepository.save(new Article(null,"Smart Tab 8","Essentield",129,"tablet.jpg",tablet,1));
//		 articleRepository.save(new Article(null,"TAB M7","Lenovo",119,"tablet.jpg",tablet,1));
//		 articleRepository.save(new Article(null,"Smart Tab 10","Essentield",149.99,"tablet.jpg",tablet,1));
//		 articleRepository.save(new Article(null,"Galaxy Tab A8","Samsung",199,"tablet.jpg",tablet,1));
//		 articleRepository.save(new Article(null,"P11","Lenovo",269,"tablet.jpg",tablet,1));	
//		
//		 articleRepository.save(new Article(null,"Home & Student","Office",126,"pinnacle.jpg",logiciel,1));
//		 articleRepository.save(new Article(null,"Nordvpn","NordVPN",50,"pinnacle.jpg",logiciel,1));
//		 articleRepository.save(new Article(null,"Platinium 365","Nero",50,"pinnacle.jpg",logiciel,1));
//		 articleRepository.save(new Article(null,"Studio 24 plus","Pinnacle",126,"pinnacle.jpg",logiciel,1));
//		 articleRepository.save(new Article(null,"Platinium unlimlited","Nero",99.99,"pinnacle.jpg",logiciel,1));
//		 articleRepository.save(new Article(null,"Studio 25 ultimate","Pinnacle",129.99,"pinnacle.jpg",logiciel,1));
//		 articleRepository.save(new Article(null,"Personnel","Microsoft 365",126,"pinnacle.jpg",logiciel,1));
//			
//		roleRepository.save(new Role(null, "USER"));
//		roleRepository.save(new Role(null, "ADMIN"));
//		 
//		userRepository.save(new User(null, "bla@bla.fr", "123", true));
//		userRepository.save(new User(null, "x@x.fr", "123", true));
	}

}
