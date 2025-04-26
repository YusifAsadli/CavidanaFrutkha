package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.product.*;
import edu.az.itbrains123.ecommerse.models.Product;
import edu.az.itbrains123.ecommerse.payload.PaginationPayload;

import java.util.List;

public interface ProductService {
    List<ProductHomeDto> getHomeProducts();
    ProductDetailDto getProductDetail(Long id);
    List<ProductRelatedDto> getRelatedProducts(Long id);
    ProductDealDto getProductDeal();

    PaginationPayload<ProductShopDto> getShopProducts(Integer currentPage);

    void createProduct(ProductCreateDto productCreateDto);
    void updateProduct(ProductUpdateDto productUpdateDto,Long id);
    void deleteProduct(Long id);
    ProductUpdateDto findProductUpdate(Long id);
    List<ProductHomeDto> findAllProducts();
    Product findProductById(Long id);
}
