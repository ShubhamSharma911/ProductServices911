package dev.shubham911.productservices911;

import dev.shubham911.productservices911.Models.Product;
import dev.shubham911.productservices911.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServices911ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	void testingQueries(){
		List<Product> products = productRepository.findAllByCategory_Title("Electronics");
		System.out.println(products);
	}
}
