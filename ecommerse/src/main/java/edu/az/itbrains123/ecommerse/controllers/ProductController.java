package edu.az.itbrains123.ecommerse.controllers;

import edu.az.itbrains123.ecommerse.dtos.product.ProductDetailDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductRelatedDto;
import edu.az.itbrains123.ecommerse.models.Product;
import edu.az.itbrains123.ecommerse.sevices.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        ProductDetailDto product = productService.getProductDetail(id);
        List<ProductRelatedDto> relatedProduct=productService.getRelatedProducts(product.getId());
        model.addAttribute("product",product);
        model.addAttribute("relatedProduct",relatedProduct);
        return "/shop/detail";
    }

}
