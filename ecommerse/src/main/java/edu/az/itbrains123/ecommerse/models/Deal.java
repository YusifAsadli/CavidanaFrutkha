package edu.az.itbrains123.ecommerse.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

}
