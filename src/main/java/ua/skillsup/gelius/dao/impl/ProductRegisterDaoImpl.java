package ua.skillsup.gelius.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.model.convert.ProductRegisterConvert;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.model.entity.ProductRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.skillsup.gelius.model.convert.ProductRegisterConvert.convert;


@Repository
@Transactional
public class ProductRegisterDaoImpl implements ProductRegisterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductRegisterDto> getAllProducts() {
        List<ProductRegister> productsRegister = sessionFactory.getCurrentSession().createCriteria(ProductRegister.class).list();
        return ProductRegisterConvert.convertList(productsRegister);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductRegisterDto> findByFilter(ProductRegisterFilter filter) {
        Criteria criteria = getFilterCriteria(filter);
        criteria = getSortingCriteria(criteria, filter);
        List<ProductRegister> products = criteria.list();
        List<ProductRegisterDto> result = new ArrayList<>(products.size());
        for (ProductRegister product : products) {
            result.add(convert(product));
        }
        return result;
    }

    private <T> List<T> getFilterParameters(final ProductRegisterFilter filter, String columnName) {
        Criteria criteria = getFilterCriteria(filter);
        criteria.setProjection(Projections.distinct(Projections.property(columnName)));
        criteria.addOrder(Order.asc(columnName));

        return criteria.list();
    }

    @Override
    public <T> Map<String, List<T>> findAllFilterParameters(ProductRegisterFilter filter) {
        Map<String, List<T>> filterParameters = new HashMap<>();
        filterParameters.put("id", getFilterParameters(filter, "id"));
        filterParameters.put("client.companyName", getFilterParameters(filter, "client.companyName"));
        filterParameters.put("productName", getFilterParameters(filter, "productName"));
        filterParameters.put("productType.productType", getFilterParameters(filter, "productType.productType"));
        filterParameters.put("innerLength", getFilterParameters(filter, "innerLength"));
        filterParameters.put("innerWidth", getFilterParameters(filter, "innerWidth"));
        filterParameters.put("innerHeight", getFilterParameters(filter, "innerHeight"));
        filterParameters.put("cardboardBrand.cardboardBrand", getFilterParameters(filter, "cardboardBrand.cardboardBrand"));
        filterParameters.put("profile.profile", getFilterParameters(filter, "profile.profile"));
        filterParameters.put("layer", getFilterParameters(filter, "faceLayer.faceLayer"));
        filterParameters.put("cliche", getFilterParameters(filter, "cliche"));

        return filterParameters;
    }

    private Criteria getSortingCriteria(Criteria criteria, ProductRegisterFilter filter) {
        String columnName = filter.getSortableColumn();

        if (filter.getSortingDirection().equals("asc"))
            criteria.addOrder(Order.asc(columnName));
        else
            criteria.addOrder(Order.desc(columnName));

        return criteria;
    }

    private Criteria getFilterCriteria(ProductRegisterFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProductRegister.class, "product");
        criteria.createAlias("product.client", "client");
        criteria.createAlias("product.cardboardBrand", "cardboardBrand");
        criteria.createAlias("product.productType", "productType");
        criteria.createAlias("product.profile", "profile");
        criteria.createAlias("product.faceLayer", "faceLayer");
        criteria.createAlias("product.innerLayer", "innerLayer");
        if (!filter.isEmpty()) {
            if (!filter.getIds().isEmpty()) {
                criteria.add(Restrictions.in("product.id", filter.getIds()));
            }
            if (!filter.getClientNames().isEmpty()) {
                criteria.add(Restrictions.in("client.companyName", filter.getClientNames()));
            }
            if (!filter.getProductNames().isEmpty()) {
                criteria.add(Restrictions.in("product.productName", filter.getProductNames()));
            }
            if (!filter.getProductTypes().isEmpty()) {
                criteria.add(Restrictions.in("productType.productType", filter.getProductTypes()));
            }
            if (!filter.getInnerLengths().isEmpty()) {
                criteria.add(Restrictions.in("product.innerLength", filter.getInnerLengths()));
            }
            if (!filter.getInnerWidths().isEmpty()) {
                criteria.add(Restrictions.in("product.innerWidth", filter.getInnerWidths()));
            }
            if (!filter.getInnerHeights().isEmpty()) {
                criteria.add(Restrictions.in("product.innerHeight", filter.getInnerHeights()));
            }
            if (!filter.getCardboardBrands().isEmpty()) {
                criteria.add(Restrictions.in("cardboardBrand.cardboardBrand", filter.getCardboardBrands()));
            }
            if (!filter.getProfiles().isEmpty()) {
                criteria.add(Restrictions.in("profile.profile", filter.getProfiles()));
            }
            if (!filter.getColours().isEmpty()) {
                criteria.add(Restrictions.in("faceLayer.faceLayer", filter.getColours()));
            }
            if (!filter.getCliches().isEmpty()) {
                criteria.add(Restrictions.in("product.cliche", filter.getCliches()));
            }
        }
        return criteria;
    }
}
