package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.service.ProductRegisterService;

import java.util.List;
import java.util.Map;

@Service
public class ProductRegisterServiceImpl implements ProductRegisterService {

    @Autowired
    private ProductRegisterDao productRegisterDao;

    @Override
    public List<ProductRegisterDto> findAll() {
        return productRegisterDao.findAll();
    }

    @Override
    public List<ProductRegisterDto> findByFilter(ProductRegisterFilter searchFilter) {
        return productRegisterDao.findByFilter(searchFilter);
    }

    @Override
    public <T> Map<String, List<T>> findAllFilterParameters(ProductRegisterFilter filter) {
        return productRegisterDao.findAllFilterParameters(filter);
    }
}
