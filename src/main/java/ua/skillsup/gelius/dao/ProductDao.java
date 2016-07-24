package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.model.entities.Client;
import ua.skillsup.gelius.model.filter.ProductFilter;

import java.util.List;

public interface ProductDao {
    Long createProduct(ProductDto productDto);

    void editProduct(ProductDto productDto);

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    List<ProductDto> findByClient(Client client);

    ProductDto findByName(String name);

    List<ProductDto> findByGrade(String grade);

    List<ProductDto> findByProfile(String profile);

    List<ProductDto> findByColour(String colour);

    List<ProductDto> findByActivity(Character activity);

    List<ProductDto> findByFilter(ProductFilter filter);
}
