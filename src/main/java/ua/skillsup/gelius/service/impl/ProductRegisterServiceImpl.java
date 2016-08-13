package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.service.ProductRegisterService;

import java.util.List;

@Service
public class ProductRegisterServiceImpl implements ProductRegisterService {

    @Autowired
    private ProductRegisterDao productRegisterDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProductRegisterDto> getAllProducts() {
        return productRegisterDao.getAllProducts();
    }

    @Override
    public List<ProductRegisterDto> findByFilter(ProductRegisterFilter searchFilter) {
        return productRegisterDao.findByFilter(searchFilter);
    }

    @Override
    public List findFilterParameters(ProductRegisterFilter filter, String filterName) {
        return productRegisterDao.findFilterParameters(filter, filterName);
    }
}
