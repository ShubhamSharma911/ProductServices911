package dev.shubham911.productservices911.Services;

import dev.shubham911.productservices911.Models.Category;
import dev.shubham911.productservices911.Models.Product;
import dev.shubham911.productservices911.exceptions.ProductNotFoundException;
import dev.shubham911.productservices911.repositories.CategoryRepository;
import dev.shubham911.productservices911.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("myProductService")
public class MyProductService implements ProductService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public MyProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product not Found");

        }
        return product.get();
    }

    @Override
    public Product createProduct(String title, String description, double price, String imageUrl, String category) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
        Category categoryFromDB = categoryRepository.findByTitle(category);

        if(categoryFromDB == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDB = newCategory;
        }
        product.setCategory(categoryFromDB);

        Product createdProduct = productRepository.save(product);

        return createdProduct;
    }
}
