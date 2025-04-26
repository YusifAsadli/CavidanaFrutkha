package edu.az.itbrains123.ecommerse.controllers;

import edu.az.itbrains123.ecommerse.dtos.product.*;
import edu.az.itbrains123.ecommerse.sevices.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/dashboard/product")
    public String products(Model model){
        List<ProductHomeDto> product=productService.findAllProducts();
        model.addAttribute("products",product);
        return "/dashboard/product/index";
    }
    @GetMapping("/dashboard/product/create")
    public String createProduct(Model model) {
        List<ProductHomeDto> data = productService.findAllProducts();
        model.addAttribute("product", data);
        return "/dashboard/product/create";
    }
    @PostMapping("/dashboard/product/create")
    public String createProduct(@ModelAttribute("order") ProductCreateDto productCreateDto) {
        productService.createProduct(productCreateDto);
        return "redirect:/dashboard/product";
    }
    @GetMapping("/dashboard/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return"/dashboard/product/delete";
    }
    @PostMapping("/dashboard/product/delete/{id}")
    public String removeProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/dashboard/product";
    }
    @GetMapping("/dashboard/product/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        ProductUpdateDto productUpdateDto = productService.findProductUpdate(id);
        model.addAttribute("product", productUpdateDto);
        return "/dashboard/product/update";
    }
    @PostMapping("/dashboard/product/update/{id}")
    public String updateProduct(@PathVariable Long id,ProductUpdateDto productUpdateDto) {
        productService.updateProduct(productUpdateDto, id);
        return "redirect:/dashboard/product";
    }




}
