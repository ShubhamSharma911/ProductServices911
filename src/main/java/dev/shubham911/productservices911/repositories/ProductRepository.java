package dev.shubham911.productservices911.repositories;

import dev.shubham911.productservices911.Models.Category;
import dev.shubham911.productservices911.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);

    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Title(String title);

    List<Product> findAllByCategory_Id(Long CategoryId);

    List<Product> findAllByTitleStartingWithAndIdEqualsAndPriceLessThan(String startingWith, Long id, Double price);

}
