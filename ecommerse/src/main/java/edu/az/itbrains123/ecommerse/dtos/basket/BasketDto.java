package edu.az.itbrains123.ecommerse.dtos.basket;

import edu.az.itbrains123.ecommerse.dtos.product.ProductBasketDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {
    private Long id;
    private Float quantity;
    private Long productId;
    private ProductBasketDto product;
}
