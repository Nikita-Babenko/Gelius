package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.ProductDto;

public interface ProductService {

    String save(ProductDto product);

    int getProductNumber();

    String getFullProductNumber(int productNumber, boolean isNewDatasheet);

    ProductDto findById(long productId);

}
