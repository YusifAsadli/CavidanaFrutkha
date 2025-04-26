package edu.az.itbrains123.ecommerse.dtos.order;

import edu.az.itbrains123.ecommerse.dtos.product.ProductDetailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Long id;
    private Double quantity;
    private Double price;
    private ProductDetailDto product;
}
