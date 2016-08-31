package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.List;
import java.util.Map;

public interface ProductRegisterDao {

    List<ProductRegisterDto> findAll();

    List<ProductRegisterDto> findByFilter(ProductRegisterFilter filter);

    <T> Map<String, List<T>> findAllFilterParameters(ProductRegisterFilter filter);

}
