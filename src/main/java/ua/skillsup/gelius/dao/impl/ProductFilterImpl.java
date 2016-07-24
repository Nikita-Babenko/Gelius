package ua.skillsup.gelius.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductFilter;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.model.entities.Product;

import java.util.ArrayList;
import java.util.List;

import static ua.skillsup.gelius.converters.EntityDtoConverter.convert;

@Repository
@Transactional
public class ProductFilterImpl implements ProductFilter{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ProductDto> filterByClient(String client) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getClient().getCompanyName().equals(client)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public ProductDto filterByProductName(String name) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        ProductDto result = null;
        for (Product product : products){
            if (product.getProductsName().equals(name)) {
                result = convert(product);
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByProductType(String type) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getProductsType().equals(type)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByInnerLength(int length) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getInnerLength().equals(length)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByInnerWidth(int width) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getInnerWidth().equals(width)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByInnerHeight(int height) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getInnerHeight().equals(height)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByGrade(String grade) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getGrade().equals(grade)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByProfile(String profile) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getProfile().equals(profile)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByColour(String colour) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getColour().equals(colour)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public List<ProductDto> filterByPrint(String print) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getPrint().equals(print)) {
                result.add(convert(product));
            }
        }
        return result;
    }
}
