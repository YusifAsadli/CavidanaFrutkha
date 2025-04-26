package edu.az.itbrains123.ecommerse.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float quantity;
    private Float price;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
