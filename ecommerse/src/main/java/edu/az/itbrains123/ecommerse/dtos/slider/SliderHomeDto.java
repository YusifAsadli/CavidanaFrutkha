package edu.az.itbrains123.ecommerse.dtos.slider;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderHomeDto {
    private Long id;
    private String photoUrl;
    private String title;
    private String description;
}
