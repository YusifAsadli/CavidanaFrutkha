package edu.az.itbrains123.ecommerse.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {
    private Long id;
    private String name;
    private Float price;
    private String description;
    private Long categoryId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date discountDate;
    private Float discountPrice;
    private Boolean featured;
    private Float quantity;
}
