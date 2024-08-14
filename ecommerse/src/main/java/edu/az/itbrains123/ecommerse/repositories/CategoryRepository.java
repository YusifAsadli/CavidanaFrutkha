package edu.az.itbrains123.ecommerse.repositories;

import edu.az.itbrains123.ecommerse.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //atmiya da bilersen
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
