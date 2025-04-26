package edu.az.itbrains123.ecommerse.dtos.order;

import edu.az.itbrains123.ecommerse.dtos.user.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDashboardDto {
    private Long id;
    private String phoneNumber;
    private String address;
    private String message;
    private UserInfoDto user;
    List<OrderItemDto> orderItems=new ArrayList<>();
}
