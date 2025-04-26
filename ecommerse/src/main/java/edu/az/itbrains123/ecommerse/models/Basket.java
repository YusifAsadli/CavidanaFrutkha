package edu.az.itbrains123.ecommerse.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private UserEntity user;
}
