package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.order.OrderDashboardDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderDetailDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderPlaceDto;
import edu.az.itbrains123.ecommerse.models.Order;

import java.util.List;

public interface OrderService {
    boolean placeOrder(OrderPlaceDto orderplaceDto, String userEmail);
    List<OrderDashboardDto> getDashboardOrder();
    List<OrderDetailDto> getOrderById(Long id);
}
