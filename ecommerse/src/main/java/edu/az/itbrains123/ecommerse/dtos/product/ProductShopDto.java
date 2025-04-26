package edu.az.itbrains123.ecommerse.dtos.product;

import edu.az.itbrains123.ecommerse.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductShopDto {
    private Long id;
    private String name;
    private Float price;
    private String photoUrl;
    private CategoryDto category;
}
