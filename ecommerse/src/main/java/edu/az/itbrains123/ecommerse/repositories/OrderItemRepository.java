package edu.az.itbrains123.ecommerse.repositories;

import edu.az.itbrains123.ecommerse.models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findByOrderId(Long orderId);
}
