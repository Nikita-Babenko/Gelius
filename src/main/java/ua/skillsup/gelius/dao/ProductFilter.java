package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsSearchFilter;

import java.util.List;

public interface ProductFilter {
    /*List<ProductDto> filterByClient(String client);
    ProductDto filterByProductName(String name);
    List<ProductDto> filterByProductType(String type);
    List<ProductDto> filterByInnerLength(int length);
    List<ProductDto> filterByInnerWidth(int width);
    List<ProductDto> filterByInnerHeight(int height);
    List<ProductDto> filterByGrade(String grade);
    List<ProductDto> filterByProfile(String profile);
    List<ProductDto> filterByColour(String colour);
    List<ProductDto> filterByPrint(String print);*/
    List<ProductDto> findByFilter(ProductsSearchFilter filter);
}
