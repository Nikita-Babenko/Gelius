package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.dao.entities.Client;
import ua.skillsup.gelius.model.ProductDto;
import ua.skillsup.gelius.model.filter.ProductFilter;

import java.util.List;

public interface ProductDao {
    Long createProduct(ProductDto productDto);
    //Update any information from ProductRegister
    void editProduct(ProductDto productDto);
    //Find by something methods
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    List<ProductDto> findByClient(Client client);
    ProductDto findByName(String name);
    List<ProductDto> findByGrade (String grade);
    List<ProductDto> findByProfile (String profile);
    List<ProductDto> findByColour (String colour);
    List<ProductDto> findByActivity (Character activity);
    List<ProductDto> findByFilter (ProductFilter filter);




}
