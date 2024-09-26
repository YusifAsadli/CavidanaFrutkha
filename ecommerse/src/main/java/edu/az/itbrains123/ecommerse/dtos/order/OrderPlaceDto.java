package edu.az.itbrains123.ecommerse.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlaceDto {
    private String phoneNumber;
    private String address;
    private String message;
}
