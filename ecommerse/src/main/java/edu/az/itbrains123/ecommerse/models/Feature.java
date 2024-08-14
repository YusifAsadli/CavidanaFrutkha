package edu.az.itbrains123.ecommerse.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private String icon;
    private String subtitle;
}
