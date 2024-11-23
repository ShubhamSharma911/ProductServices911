package dev.shubham911.productservices911.Services;

import dev.shubham911.productservices911.Models.Product;
import dev.shubham911.productservices911.dtos.CreateProductRequestDto;
import dev.shubham911.productservices911.dtos.FakeStoreProductDto;
import dev.shubham911.productservices911.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    /*
    to call the thi external api we will call restTemplate:
     */
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =  restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        List<Product>  product = new ArrayList<Product>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            Product  p = fakeStoreProductDto.toProduct();
            product.add(p);
        }
        return product;
    }

    @Override
    public Product getSingleProduct(long id) {
        // call the external fakestore api
        //  https://fakestoreapi.com/products/1

//        FakeStoreProductDto fakeStoreProductDto =
//                restTemplate.getForObject("https://fakestoreapi.com/products/1" + id,
//                        FakeStoreProductDto.class);

              ResponseEntity<FakeStoreProductDto > fakeStoreProductDtoResponseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/1" + id,
                        FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found");
        }
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);

        restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }
}