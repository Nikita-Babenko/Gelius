package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.ProductsFilteringAndSortingDTO;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findById(Long id);
    Long createProduct(ProductDto product);
    void editProduct(ProductDto prodcut);
    void deleteProduct(Long id);
    List<ProductDto> getProductsByFilterAndSorting(ProductsFilteringAndSortingDTO searchFilter);
    List findFilterParameters(ProductsFilteringAndSortingDTO filter, String filterName);
}
