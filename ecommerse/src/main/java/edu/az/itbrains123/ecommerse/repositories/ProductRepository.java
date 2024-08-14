package edu.az.itbrains123.ecommerse.repositories;

import edu.az.itbrains123.ecommerse.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long id);
    Product findByFeaturedTrue();
}
