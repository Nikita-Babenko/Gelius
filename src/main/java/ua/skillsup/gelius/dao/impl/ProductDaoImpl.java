package ua.skillsup.gelius.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.model.entities.Client;
import ua.skillsup.gelius.model.entities.Product;
import ua.skillsup.gelius.model.filter.ProductFilter;

import java.util.ArrayList;
import java.util.List;

import static ua.skillsup.gelius.converters.EntityDtoConverter.convert;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long createProduct(ProductDto productDto) {
        Product product = convert(productDto);
        return (Long) sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void editProduct(ProductDto productDto) {
        Product product = convert(productDto);
        sessionFactory.getCurrentSession().merge(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = sessionFactory
                .getCurrentSession()
                .createQuery("from Product")
                .list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products){
            result.add(convert(product));
        }
        return result;
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = (Product) sessionFactory
                .getCurrentSession()
                .createQuery("select i from Product i where i.id = :id")
                .setParameter("id", id)
                .uniqueResult();

        if (product == null){
            return null;
        }else {
            return convert(product);
        }
    }

    @Override
    public List<ProductDto> findByClient(Client client) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products){
            if (product.getClient().equals(client)) {
                result.add(convert(product));
            }
        }
        return result;
    }

    @Override
    public ProductDto findByName(String name) {
        Product product = (Product) sessionFactory.getCurrentSession().createQuery("select n from Product n where n.name = :name")
                .setParameter("name", name);
        if (product == null){
            return null;
        }else {
            return convert(product);
        }

    }

    @Override
    public List<ProductDto> findByGrade(String grade) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select g from Product g where g.grade = :grade").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products){
            if (product.getGrade().equals(grade))
            result.add(convert(product));
        }
        return result;

    }

    @Override
    public List<ProductDto> findByProfile(String profile) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select p from Product p where p.profile = :profile").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products){
            if (product.getProfile().equals(profile))
                result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> findByColour(String colour) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select c from Product c where c.colour = :colour").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products){
            if (product.getColour().equals(colour))
                result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> findByActivity(Character activity) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select a from Product a where a.activity = :activity").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products){
            if (product.getActivity().equals(activity))
                result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> findByFilter(ProductFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        if (filter.getHeightFrom()!= null){
            criteria.add(Restrictions.gt("height", filter.getHeightFrom()));
        }
        if (filter.getHeightTo() != null){
            criteria.add(Restrictions.lt("height", filter.getHeightTo()));
        }
        if (filter.getWidthFrom() != null){
            criteria.add(Restrictions.gt("width", filter.getWidthFrom()));
        }
        if (filter.getWidthTo() != null){
            criteria.add(Restrictions.lt("width", filter.getWidthTo()));
        }
        if (filter.getLengthFrom() != null){
            criteria.add(Restrictions.gt("weight", filter.getLengthFrom()));
        }
        if (filter.getLengthTo() != null){
            criteria.add(Restrictions.lt("weight", filter.getLengthTo()));
        }
        List<Product> products = criteria.list();
        List<ProductDto> result = new ArrayList<ProductDto>(products.size());
        for (Product product : products){
            result.add(convert(product));
        }
        return result;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = (Product) sessionFactory
                .getCurrentSession()
                .createQuery("FROM Product WHERE :id = id")
                .setParameter("id",id)
                .uniqueResult();

        sessionFactory.getCurrentSession().delete(product);

    }
}
