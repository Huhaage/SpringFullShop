package fr.fms.SpringFullShop;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

@SpringBootTest
class SpringFullShopApplicationTests {
	@Autowired
	IBusinessImpl iBusinessImpl;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testTotalCaddy() {
		iBusinessImpl.addToCaddy(1L);
		iBusinessImpl.addToCaddy(2L);
		assertEquals(iBusinessImpl.totalCaddy(), 750);
	}
	
	
}
