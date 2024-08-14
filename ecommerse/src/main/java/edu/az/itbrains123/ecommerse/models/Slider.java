package edu.az.itbrains123.ecommerse.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sliders")
public class Slider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;
    private String title;
    private String description;
}
