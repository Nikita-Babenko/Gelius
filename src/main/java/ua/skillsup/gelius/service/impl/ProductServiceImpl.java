package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.ProductsFilteringAndSortingDTO;
import ua.skillsup.gelius.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

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
    public List<ProductDto> getProductsByFilterAndSorting(ProductsFilteringAndSortingDTO searchFilter) {
        return productDao.findByFilterAndSorting(searchFilter);
    }

    @Override
    public List findFilterParameters(ProductsFilteringAndSortingDTO filter, String filterName) {
        return productDao.findFilterParameters(filter, filterName);
    }
}
