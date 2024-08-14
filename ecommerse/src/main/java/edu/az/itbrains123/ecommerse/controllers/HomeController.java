package edu.az.itbrains123.ecommerse.controllers;

import edu.az.itbrains123.ecommerse.dtos.product.ProductDealDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductHomeDto;
import edu.az.itbrains123.ecommerse.dtos.slider.SliderHomeDto;
import edu.az.itbrains123.ecommerse.dtos.testimonial.TestimonialDto;
import edu.az.itbrains123.ecommerse.models.Product;
import edu.az.itbrains123.ecommerse.sevices.ProductService;
import edu.az.itbrains123.ecommerse.sevices.SliderService;
import edu.az.itbrains123.ecommerse.sevices.TestimonialService;
import edu.az.itbrains123.ecommerse.sevices.impls.TestimonialServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final SliderService sliderService;
    private final ProductService productService;
    private final TestimonialService testimonialService;

    public HomeController(SliderService sliderService, ProductService productService, TestimonialServiceImpl testimonialServiceImpl, TestimonialService testimonialService) {
        this.sliderService = sliderService;
        this.productService = productService;
        this.testimonialService = testimonialService;
    }

    @GetMapping("/")
    public String home(Model model) {
      List<ProductHomeDto> products = productService.getHomeProducts();
      List<SliderHomeDto> sliders = sliderService.getSliders();
        ProductDealDto deal=productService.getProductDeal();
        List<TestimonialDto> testimonials=testimonialService.getTestimonials();
        model.addAttribute("products", products);
        model.addAttribute("sliders", sliders);
        model.addAttribute("deal", deal);
        model.addAttribute("testimonials", testimonials);
        return "/index";
    }
    @GetMapping("/about")
    public String about(){return "/about";}
    @GetMapping("/contact")
    public String contact(){return "/contact";}
    @GetMapping("/news")
    public String news(){return "/news/index";}
    @GetMapping("/shop")
    public String shop(){return "/shop/index";}
}
