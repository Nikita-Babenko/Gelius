package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.Response;
import ua.skillsup.gelius.model.dto.ProductDto;

public interface ProductService {
    Response createProduct(ProductDto product);
}
