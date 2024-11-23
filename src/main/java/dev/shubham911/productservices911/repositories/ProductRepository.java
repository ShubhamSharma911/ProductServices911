package dev.shubham911.productservices911.repositories;

import dev.shubham911.productservices911.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
}
