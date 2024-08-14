package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.CategoryCreateDto;
import edu.az.itbrains123.ecommerse.dtos.CategoryHomeDto;
import edu.az.itbrains123.ecommerse.dtos.CategoryUpdateDto;
import edu.az.itbrains123.ecommerse.models.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryCreateDto categoryCreateDto);
    void updateCategory(CategoryUpdateDto categoryUpdateDto,Long id);
    void deleteCategory(Long id);
    CategoryUpdateDto findUpdateCategory(Long id);
    List<CategoryHomeDto> getHomeCategories();
    public Category findCategoryById(Long id);
}
