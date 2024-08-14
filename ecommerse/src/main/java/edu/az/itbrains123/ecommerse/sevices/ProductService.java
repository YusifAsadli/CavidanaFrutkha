package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.product.ProductDealDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductDetailDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductHomeDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductRelatedDto;
import edu.az.itbrains123.ecommerse.dtos.testimonial.TestimonialDto;
import edu.az.itbrains123.ecommerse.models.Product;

import java.util.List;

public interface ProductService {
    List<ProductHomeDto> getHomeProducts();
    ProductDetailDto getProductDetail(Long id);
    List<ProductRelatedDto> getRelatedProducts(Long id);
    ProductDealDto getProductDeal();

}
