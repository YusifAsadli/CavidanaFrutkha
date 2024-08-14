package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.testimonial.TestimonialDto;
import edu.az.itbrains123.ecommerse.models.Testimonial;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TestimonialService {
List<TestimonialDto> getTestimonials();
}
