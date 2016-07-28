package ua.skillsup.gelius.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsSearchFilter;
import ua.skillsup.gelius.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Qualifier("productDaoImpl")
    @Autowired
    ProductDao productDao;



    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Long createProduct(ProductDto product) {
        return productDao.createProduct(product);
    }

    @Override
    public void editProduct(ProductDto product) {
        productDao.editProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }

    @Override
    public ProductDto findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<ProductDto> getProductsByFilter(ProductsSearchFilter searchFilter) {
        return productDao.findByFilter(searchFilter);
    }
}
