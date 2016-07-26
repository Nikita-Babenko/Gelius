package ua.skillsup.gelius.services;

import ua.skillsup.gelius.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findById(Long id);
    Long createProduct(ProductDto product);
    void editProduct(ProductDto prodcut);
    void deleteProduct(Long id);
}