package edu.az.itbrains123.ecommerse.dtos.product;

import edu.az.itbrains123.ecommerse.dtos.category.CategoryDto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetailDto {
    private Long id;
    private String name;
    private Float price;
    private String description;
    private CategoryDto category;
}
