package edu.az.itbrains123.ecommerse.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRelatedDto {
    private Long id;
    private String name;
    private Float price;

}
