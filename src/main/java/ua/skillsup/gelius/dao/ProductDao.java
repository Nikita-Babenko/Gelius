package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.List;

public interface ProductDao {
    Long createProduct(ProductRegisterDto productDto);

    void editProduct(ProductRegisterDto productDto);

    List<ProductRegisterDto> findAll();

    ProductRegisterDto findById(Long id);

    void deleteProduct(Long id);

    List<ProductRegisterDto> findByClient(String client);

    ProductRegisterDto findByName(String name);

    List<ProductRegisterDto> findByCardboardBrand(String cardboardBrand);

    List<ProductRegisterDto> findByProfile(String profile);

    List<ProductRegisterDto> findByColour(String colour);

    List<ProductRegisterDto> findByActivity(Character activity);

    List<ProductRegisterDto> findByFilterAndSorting(ProductRegisterFilter filter);

    List findFilterParameters(ProductRegisterFilter filter, String filterName);
}
