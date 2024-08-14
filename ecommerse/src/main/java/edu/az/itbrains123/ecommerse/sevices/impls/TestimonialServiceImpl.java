package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.testimonial.TestimonialDto;
import edu.az.itbrains123.ecommerse.models.Testimonial;
import edu.az.itbrains123.ecommerse.repositories.TestimonialRepository;
import edu.az.itbrains123.ecommerse.sevices.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {
    private final TestimonialRepository testimonialRepository;
    private final ModelMapper modelMapper;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository, ModelMapper modelMapper) {
        this.testimonialRepository = testimonialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonialDto> getTestimonials() {
        List<Testimonial> findTestimonials = testimonialRepository.findAll();
        List<TestimonialDto> testimonials = findTestimonials.stream().map(x->modelMapper.map(x,TestimonialDto.class)).collect(Collectors.toList());
        return testimonials;
    }
}
