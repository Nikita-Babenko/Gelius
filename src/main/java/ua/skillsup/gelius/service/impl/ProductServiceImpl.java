package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProductRegisterDto> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Long createProduct(ProductRegisterDto product) {
        return productDao.createProduct(product);
    }

    @Override
    public void editProduct(ProductRegisterDto product) {
        productDao.editProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }

    @Override
    public ProductRegisterDto findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<ProductRegisterDto> getProductsByFilterAndSorting(ProductRegisterFilter searchFilter) {
        return productDao.findByFilterAndSorting(searchFilter);
    }

    @Override
    public List findFilterParameters(ProductRegisterFilter filter, String filterName) {
        return productDao.findFilterParameters(filter, filterName);
    }
}
