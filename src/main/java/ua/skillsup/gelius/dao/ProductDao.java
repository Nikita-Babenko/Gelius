package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.dto.ProductDto;

import java.util.List;

public interface ProductDao {

    List<ProductDto> findAll();

    long save(ProductDto product);

    ProductDto delete(long productId);

    int getMaxNumberOfNewProduct();

    ProductDto findById(long productId);

    boolean isOldProductExist(int productNumber);

}
