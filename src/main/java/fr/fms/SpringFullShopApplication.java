package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;

@SpringBootApplication
public class SpringFullShopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringFullShopApplication.class, args);
	}

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
  
	@Override
	public void run(String... args) throws Exception {
		
	}
}
