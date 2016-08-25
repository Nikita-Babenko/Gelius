package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.ProductDto;

public interface ProductService {
    String createProduct(ProductDto product);
    int getProductNumberOfNewDatasheet();
    String getFullProductNumber(int productNumber, boolean isNewDatasheet);
    ProductDto findById(long productId);
}
