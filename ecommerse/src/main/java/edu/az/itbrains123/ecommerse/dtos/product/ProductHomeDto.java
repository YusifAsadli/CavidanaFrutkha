package edu.az.itbrains123.ecommerse.dtos.product;

import edu.az.itbrains123.ecommerse.dtos.category.CategoryHomeDto;
import edu.az.itbrains123.ecommerse.models.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductHomeDto {
    private Long id;
    private String name;
    private Float price;
    private Float quantity;
    private String description;
    private Date discountDate;
    private Float discountPrice;
    private Boolean featured;
    private CategoryHomeDto category;

}
