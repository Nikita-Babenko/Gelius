package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsFilteringAndSortingDTO;

import java.util.List;

public interface ProductDao {
    Long createProduct(ProductDto productDto);

    void editProduct(ProductDto productDto);

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    void deleteProduct(Long id);

    List<ProductDto> findByClient(String client);

    ProductDto findByName(String name);

    List<ProductDto> findByCardboardBrand(String cardboardBrand);

    List<ProductDto> findByProfile(String profile);

    List<ProductDto> findByColour(String colour);

    List<ProductDto> findByActivity(Character activity);

    List<ProductDto> findByFilterAndSorting(ProductsFilteringAndSortingDTO filter);

    List findFilterParameters(ProductsFilteringAndSortingDTO filter, String filterName);
}
