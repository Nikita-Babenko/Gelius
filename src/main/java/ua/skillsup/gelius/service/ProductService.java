package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.Response;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;

import java.util.List;

public interface ProductService {
    List<ProductRegisterDto> getAllProducts();
    Response createProduct(ProductDto product);
}
