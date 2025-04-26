package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.category.CategoryCreateDto;
import edu.az.itbrains123.ecommerse.dtos.category.CategoryHomeDto;
import edu.az.itbrains123.ecommerse.dtos.category.CategoryUpdateDto;
import edu.az.itbrains123.ecommerse.models.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryCreateDto categoryCreateDto);
    void updateCategory(CategoryUpdateDto categoryUpdateDto,Long id);
    void deleteCategory(Long id);
    CategoryUpdateDto findUpdateCategory(Long id);
    List<CategoryHomeDto> getHomeCategories();
    Category findCategoryById(Long id);
}
