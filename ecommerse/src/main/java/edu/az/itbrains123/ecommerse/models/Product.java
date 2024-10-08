package edu.az.itbrains123.ecommerse.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private Float quantity;
    @Column(length = 1000)
    private String description;
    private Date discountDate;
    private Float discountPrice;
    private Boolean featured;



    @ManyToOne
    private Category category;



}
