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

	@Test
	void testingQueries(){
		List<Product> products = productRepository.findAll();
		if(products == null|| products.isEmpty()){
			System.out.println("No products found");
		}
		else{
			System.out.println("Found "+products.size()+" products");
		}
		for(Product p : products){
			System.out.println(p.getTitle());
		}
	}

	@Test
	public void testingQueries2(){
		Product product = productRepository.getProductWithSpecificTitleAndId("fridge", 7L);
		System.out.println(product.getTitle());
	}
}
