package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;


@SpringBootApplication
public class SpringFullShopApplication implements CommandLineRunner {
	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringFullShopApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Category smartphone = categoryRepository.save(new Category(null,"Smartphone",null));
        Category tablet = categoryRepository.save(new Category(null,"Tablet",null)); 
        Category pc = categoryRepository.save(new Category(null,"PC",null));
		Category logiciel = categoryRepository.save(new Category(null,"logiciel",null));
		
		articleRepository.save(new Article(null,"S8","SamSung",350,"",smartphone));
		articleRepository.save(new Article(null,"S10","SamSung",400,"",smartphone));
		articleRepository.save(new Article(null,"S11","SamSung",420,"",smartphone));
		articleRepository.save(new Article(null,"SE","iPhone",650,"",smartphone));
		articleRepository.save(new Article(null,"Redmi Go","Xiaomi",200,"",smartphone));
		articleRepository.save(new Article(null,"Mate X","Huawei",180,"",smartphone));
		articleRepository.save(new Article(null,"Redmi9A","Xiaomi",150,"",smartphone));
		
		articleRepository.save(new Article(null,"Predator PO3","Acer",1899.99,"",pc));
		articleRepository.save(new Article(null,"SK15","Skillkorp",1199.99,"",pc));
		articleRepository.save(new Article(null,"SK45","Skillkorp",1599.99,"",pc));
		articleRepository.save(new Article(null,"Omen GT21","HP",1599.99,"",pc));
		articleRepository.save(new Article(null,"SK16","Skillkorp",899.99,"",pc));
		articleRepository.save(new Article(null,"GT22","HP",4299,"",pc));
		articleRepository.save(new Article(null,"Predator PO7","Acer",2699.99,"",pc));
		
		
		articleRepository.save(new Article(null,"TAB M10","Lenovo",299.99,"",tablet));
		articleRepository.save(new Article(null,"Galaxy Tab A7","Samsung",179,"",tablet));
		articleRepository.save(new Article(null,"Smart Tab 8","Essentield",129,"",tablet));
		articleRepository.save(new Article(null,"TAB M7","Lenovo",119,"",tablet));
		articleRepository.save(new Article(null,"Smart Tab 10","Essentield",149.99,"",tablet));
		articleRepository.save(new Article(null,"Galaxy Tab A8","Samsung",199,"",tablet));
		articleRepository.save(new Article(null,"P11","Lenovo",269,"",tablet));	
		
		articleRepository.save(new Article(null,"Home & Student","Office",126,"",logiciel));
		articleRepository.save(new Article(null,"Nordvpn","NordVPN",50,"",logiciel));
		articleRepository.save(new Article(null,"Platinium 365","Nero",50,"",logiciel));
		articleRepository.save(new Article(null,"Studio 24 plus","Pinnacle",126,"",logiciel));
		articleRepository.save(new Article(null,"Platinium unlimlited","Nero",99.99,"",logiciel));
		articleRepository.save(new Article(null,"Studio 25 ultimate","Pinnacle",129.99,"",logiciel));
		articleRepository.save(new Article(null,"Personnel","Microsoft 365",126,"",logiciel));
		
		
		
	}

}
