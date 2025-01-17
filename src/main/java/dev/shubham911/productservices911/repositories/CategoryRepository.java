package dev.shubham911.productservices911.repositories;

import dev.shubham911.productservices911.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {
    Category findByTitle(String title);
    Category findById(long id);
}
