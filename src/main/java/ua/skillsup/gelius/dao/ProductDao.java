package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.dto.ProductDto;

import java.util.List;

public interface ProductDao {
    List<ProductDto> getAllProducts();

    long create(ProductDto product);

    int getMaxProductNumberOfNewDatasheets();

    ProductDto findById(long productId);

    boolean isExistsOldProductWithSameProductNumber(int productNumber);
}
