package edu.az.itbrains123.ecommerse.repositories;

import edu.az.itbrains123.ecommerse.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
