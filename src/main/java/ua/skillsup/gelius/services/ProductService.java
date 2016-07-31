package ua.skillsup.gelius.services;

import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsFilteringAndSortingDTO;
import ua.skillsup.gelius.dto.ProductsSortingDTO;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findById(Long id);
    Long createProduct(ProductDto product);
    void editProduct(ProductDto prodcut);
    void deleteProduct(Long id);
    List<ProductDto> getProductsByFilter(ProductsFilteringAndSortingDTO searchFilter);
    List findFilterParameters(ProductsFilteringAndSortingDTO filter, String filterName);
    List<ProductDto> sortingBySelectionOrderAsc(ProductsSortingDTO sorting);//According sub-task #1111
    List<ProductDto> sortingBySelectionOrderDesc(ProductsSortingDTO sorting);//According sub-task #1111
}
