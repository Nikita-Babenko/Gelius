package ua.skillsup.gelius.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.model.ProductDto;
import ua.skillsup.gelius.services.ProductServ;

import java.util.List;

/**
 * Created by yaroslav on 7/23/16.
 */

@Service
public class ProductServImpl implements ProductServ{
    @Autowired
    ProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        return productDao.findAll();
    }
}
