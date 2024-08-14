package edu.az.itbrains123.ecommerse.dtos.product;

import edu.az.itbrains123.ecommerse.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDealDto {
    private Long id;
    private String name;
    private Float price;
    private String photoUrl;
    private String description;
    private CategoryDto category;
    private Date discountDate;
    private Float discountPrice;
    private Float discountPercent;
}
