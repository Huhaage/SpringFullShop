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
		Category logicielCategory = categoryRepository.save(new Category(null,"logiciel",null));
		
		articleRepository.save(new Article(null,"S8","SamSung",350,smartphone));
		articleRepository.save(new Article(null,"S10","SamSung",400,smartphone));
		articleRepository.save(new Article(null,"S11","SamSung",420,smartphone));
		articleRepository.save(new Article(null,"SE","iPhone",650,smartphone));
		articleRepository.save(new Article(null,"Redmi Go","Xiaomi",200,smartphone));
		articleRepository.save(new Article(null,"Mate X","Huawei",180,smartphone));
		articleRepository.save(new Article(null,"Redmi9A","Xiaomi",150,smartphone));

		
		
	}

}
