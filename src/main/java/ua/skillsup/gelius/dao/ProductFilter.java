package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsSearchFilter;

import java.util.List;

public interface ProductFilter {

    List<ProductDto> findByFilter(ProductsSearchFilter filter);
}
