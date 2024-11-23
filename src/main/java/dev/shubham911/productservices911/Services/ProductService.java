package dev.shubham911.productservices911.Services;

import dev.shubham911.productservices911.Models.Product;
import dev.shubham911.productservices911.dtos.CreateProductRequestDto;
import dev.shubham911.productservices911.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
     List<Product> getAllProducts();
     Product getSingleProduct(long id) throws ProductNotFoundException;
     Product createProduct(String title,
                          String description,
                          double price,
                          String imageUrl,
                          String category);
}
