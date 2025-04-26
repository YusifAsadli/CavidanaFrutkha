package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.product.*;
import edu.az.itbrains123.ecommerse.models.Category;
import edu.az.itbrains123.ecommerse.models.Product;
import edu.az.itbrains123.ecommerse.payload.PaginationPayload;
import edu.az.itbrains123.ecommerse.repositories.ProductRepository;
import edu.az.itbrains123.ecommerse.sevices.CategoryService;
import edu.az.itbrains123.ecommerse.sevices.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public List<ProductHomeDto> getHomeProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductHomeDto> result = products.stream().limit(3).map(x -> modelMapper.map(x, ProductHomeDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductDetailDto getProductDetail(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductDetailDto result = modelMapper.map(product, ProductDetailDto.class);
        return result;
    }

    @Override
    public List<ProductRelatedDto> getRelatedProducts(Long id) {
        Product findProduct = productRepository.findById(id).orElseThrow();
        List<Product> products = productRepository.findByCategoryId(findProduct.getCategory().getId());
        List<ProductRelatedDto> result = products.stream().filter(x -> x.getCategory().getId() == findProduct.getCategory().getId()).map(x -> modelMapper.map(x, ProductRelatedDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductDealDto getProductDeal() {
        Product product = productRepository.findByFeaturedTrue();
        ProductDealDto result = modelMapper.map(product, ProductDealDto.class);
        float percent = result.getDiscountPrice() * 100 / result.getPrice();
        result.setDiscountPercent((float) Math.round(percent));
        return result;
    }

    @Override
    public PaginationPayload<ProductShopDto> getShopProducts(Integer currentPage) {
        currentPage = currentPage == null ? 1 : currentPage > 0 ? currentPage : 1;
        Pageable pageable = PageRequest.of(currentPage - 1, 6, Sort.by("id").descending());
        Page<Product> sortProducts = productRepository.findAll(pageable);
        PaginationPayload result = new PaginationPayload<>(sortProducts.getTotalPages(), sortProducts.getContent());
        return result;
    }

    @Override
    public void createProduct(ProductCreateDto productCreateDto) {
        Category findCategory = categoryService.findCategoryById(productCreateDto.getCategoryId());
        Product product = new Product();
        product.setName(productCreateDto.getName());
        product.setDescription(productCreateDto.getDescription());
        product.setPrice(productCreateDto.getPrice());
        product.setCategory(findCategory);
        product.setDiscountPrice(productCreateDto.getDiscountPrice());
        product.setDiscountDate(productCreateDto.getDiscountDate());
        product.setQuantity(productCreateDto.getQuantity());
        product.setFeatured(productCreateDto.getFeatured());
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductUpdateDto productUpdateDto, Long id) {
        Category findCategory = categoryService.findCategoryById(productUpdateDto.getCategoryId());
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productUpdateDto.getName());
        product.setDescription(productUpdateDto.getDescription());
        product.setPrice(productUpdateDto.getPrice());
        product.setCategory(findCategory);
        product.setDiscountPrice(productUpdateDto.getDiscountPrice());
        product.setDiscountDate(productUpdateDto.getDiscountDate());
        product.setQuantity(productUpdateDto.getQuantity());
        product.setFeatured(productUpdateDto.getFeatured());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

    @Override
    public ProductUpdateDto findProductUpdate(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductUpdateDto result = modelMapper.map(product, ProductUpdateDto.class);
        return result;
    }

    @Override
    public List<ProductHomeDto> findAllProducts() {
        List<ProductHomeDto> products = productRepository.findAll().stream().map(x -> modelMapper.map(x, ProductHomeDto.class)).collect(Collectors.toList());
        return products;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }


}
