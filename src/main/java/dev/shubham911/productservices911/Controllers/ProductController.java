package dev.shubham911.productservices911.Controllers;

import dev.shubham911.productservices911.Models.Product;
import dev.shubham911.productservices911.Services.ProductService;
import dev.shubham911.productservices911.dtos.CreateProductRequestDto;
import dev.shubham911.productservices911.dtos.ErrorDto;
import dev.shubham911.productservices911.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    public ProductService productService;

    public ProductController(@Qualifier("myProductService") ProductService productService){
        this.productService = productService;
    }


    /*
    in laymen terms
    what is api = api is a method in my controller
     */

    /*
    for getting details of a product http verb GET
    endpoint to get details of a product


    GET / product
     */
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    // GET/product/{id}
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        Product p = productService.getSingleProduct(id);

        if(p == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(p, HttpStatus.OK);
    }

    /*
    to create a product we will be sending a lot of details
        title;
        description;
        price;
        category;
        products
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getPrice(),
                createProductRequestDto.getImage(),
                createProductRequestDto.getCategory());
    }


}