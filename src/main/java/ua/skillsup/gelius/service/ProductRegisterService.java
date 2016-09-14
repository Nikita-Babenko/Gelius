package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.List;
import java.util.Map;

public interface ProductRegisterService {

    List<ProductRegisterDto> findByFilter(ProductRegisterFilter searchFilter);

    <T> Map<String, List<T>> findAllFilterParameters(ProductRegisterFilter filter);
}
