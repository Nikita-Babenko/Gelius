package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.dto.ProductDto;

import java.util.List;

public interface ProductDao {

    List<ProductDto> getAllProducts();

}
