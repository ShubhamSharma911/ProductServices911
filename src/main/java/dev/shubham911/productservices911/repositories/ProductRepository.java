package dev.shubham911.productservices911.repositories;

import dev.shubham911.productservices911.Models.Category;
import dev.shubham911.productservices911.Models.Product;
import dev.shubham911.productservices911.repositories.projections.ProductWithTitleAndId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);

    Product findByIdIs(long id);

    List<Product> findAll();

    List<Product> findByCategory(Category category);
    // hql queries
    @Query("select p from Product p where p.category.title = :title and p.id = :id")
    Product getProductWithSpecificTitleAndId(@Param("title") String title,@Param("id")Long id);
    // native queries

    @Query(value = "select * from product where title = :title", nativeQuery = true)
    List<Product> getProductWithSpecificTitle(@Param("title") String title);

    @Query("select p from Product p where p.title = :title and p.id = :id")
    ProductWithTitleAndId getProductWithSpecificTitleAndId2(@Param("title") String title, @Param("id") Long id);


}
