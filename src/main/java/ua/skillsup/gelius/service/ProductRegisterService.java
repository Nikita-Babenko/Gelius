package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.List;

public interface ProductRegisterService {

    List<ProductRegisterDto> getAllProducts();

    List<ProductRegisterDto> findByFilter(ProductRegisterFilter searchFilter);

    List findFilterParameters(ProductRegisterFilter filter, String filterName);
}
