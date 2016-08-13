package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.List;

public interface ProductRegisterDao {

    List<ProductRegisterDto> getAllProducts();

    List<ProductRegisterDto> findByFilter(ProductRegisterFilter filter);

    List findFilterParameters(ProductRegisterFilter filter, String filterName);

}
