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
		// Category smartphone = categoryRepository.save(new Category(null,"Smartphone",null));
        // Category tablet = categoryRepository.save(new Category(null,"Tablet",null)); 
        // Category pc = categoryRepository.save(new Category(null,"PC",null));
		// Category logicielCategory = categoryRepository.save(new Category(null,"logiciel",null));
		
		// articleRepository.save(new Article(null,"S8","SamSung",350,"unknown.png", smartphone));
		// articleRepository.save(new Article(null,"S10","SamSung",400,"unknown.png",smartphone));
		// articleRepository.save(new Article(null,"S11","SamSung",420,"unknown.png",smartphone));
		// articleRepository.save(new Article(null,"SE","iPhone",650,"unknown.png",tablet));
		// articleRepository.save(new Article(null,"Redmi Go","Xiaomi",200,"unknown.png",smartphone));
		// articleRepository.save(new Article(null,"Mate X","Huawei",180,	"unknown.png",logicielCategory));
		// articleRepository.save(new Article(null,"Redmi9A","Xiaomi",150,"unknown.png",pc));

		
		
	}

}
