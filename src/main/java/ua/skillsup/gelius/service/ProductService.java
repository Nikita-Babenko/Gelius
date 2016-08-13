package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.List;

public interface ProductService {
    List<ProductRegisterDto> getAllProducts();

    ProductRegisterDto findById(Long id);

    Long createProduct(ProductRegisterDto product);

    void editProduct(ProductRegisterDto product);

    void deleteProduct(Long id);

    List<ProductRegisterDto> getProductsByFilterAndSorting(ProductRegisterFilter searchFilter);

    List findFilterParameters(ProductRegisterFilter filter, String filterName);
}
