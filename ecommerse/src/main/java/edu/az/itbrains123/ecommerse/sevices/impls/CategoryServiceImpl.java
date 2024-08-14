package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.CategoryCreateDto;
import edu.az.itbrains123.ecommerse.dtos.CategoryHomeDto;
import edu.az.itbrains123.ecommerse.dtos.CategoryUpdateDto;
import edu.az.itbrains123.ecommerse.models.Category;
import edu.az.itbrains123.ecommerse.repositories.CategoryRepository;
import edu.az.itbrains123.ecommerse.sevices.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);

    }

    @Override
    public void updateCategory(CategoryUpdateDto categoryUpdateDto,Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryUpdateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryUpdateDto findUpdateCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        CategoryUpdateDto result = modelMapper.map(category, CategoryUpdateDto.class);
        return result;
    }

    @Override
    public List<CategoryHomeDto> getHomeCategories() {
        List<CategoryHomeDto> categories = categoryRepository.findAll()
                .stream()
                .map(category -> modelMapper.map(category,CategoryHomeDto.class)).toList();
        return categories;
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
