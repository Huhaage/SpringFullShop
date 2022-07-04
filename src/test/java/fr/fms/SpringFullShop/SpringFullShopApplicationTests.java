package fr.fms.SpringFullShop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootTest
class SpringFullShopApplicationTests {
	@Autowired
	IBusinessImpl iBusinessImpl;
	
	@Test
	void contextLoads() {
		assertFalse(1 == 2);
	}
	
	@Test
	void testTotalCaddy() {
		//clear caddy
		iBusinessImpl.addToCaddy((long) 15);
		iBusinessImpl.addToCaddy(16L);
		
		//add plusieurs quantités et voir la taille du caddy
		
		//assertEquals(iBusinessImpl.totalCaddy(), 820);
		assertEquals(iBusinessImpl.sizeCaddy(), 2);
	}
	
	@Test
	void testAddArticle() {
		iBusinessImpl.addArticle(new Article(null, "Descr", "Brand", 125.55893, "unknown.png", new Category((long) 1, "Z", "unknown.png"), 1));	
	}
	
	@Test
	void testGetArticle() {
		assertThat(iBusinessImpl.getArticleById((long) 16)).isNotNull();
	}
	
	@Test
	void testReadCategories() {
		assertThat(iBusinessImpl.readCategoryById((long) 1)).isNotNull();
	}
	
	@Test
	void testGetUser() {
		assertFalse(iBusinessImpl.getUser((long) 5).getActive()); 
	}
	
	@Test
	void testEqualUser() {
		assertEquals((long) 1, iBusinessImpl.getIdUserByMail("Neo@free.fr"));
	}
}
