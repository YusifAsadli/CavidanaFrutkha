package edu.az.itbrains123.ecommerse.models;

import edu.az.itbrains123.ecommerse.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String address;
    private String message;

    private OrderStatus orderStatus;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "order")
    private List<OrderItems> orderItems=new ArrayList<>();
}
