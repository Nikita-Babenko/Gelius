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
import ua.skillsup.gelius.model.convert.ProductRegisterDtoConvert;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.model.entity.ProductRegister;

import java.util.ArrayList;
import java.util.List;

import static ua.skillsup.gelius.model.convert.ProductRegisterDtoConvert.convert;


@Repository
@Transactional
public class ProductRegisterDaoImpl implements ProductRegisterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductRegisterDto> getAllProducts() {
        List<ProductRegister> productsRegister = sessionFactory.getCurrentSession().createCriteria(ProductRegister.class).list();
        return ProductRegisterDtoConvert.convertList(productsRegister);
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

    @Override
    public List findFilterParameters(ProductRegisterFilter filter, String filterName) {
        Criteria criteria = getFilterCriteria(filter);
        switch (filterName) {
            case "ids":
                criteria.setProjection(Projections.distinct(Projections.property("id")));
                criteria.addOrder(Order.asc("id"));
                break;
            case "clients":
                criteria.setProjection(Projections.distinct(Projections.property("client.companyName")));
                criteria.addOrder(Order.asc("client.companyName"));
                break;
            case "names":
                criteria.setProjection(Projections.distinct(Projections.property("productsName")));
                criteria.addOrder(Order.asc("productsName"));
                break;
            case "types":
                criteria.setProjection(Projections.distinct(Projections.property("productsType.productsType")));
                criteria.addOrder(Order.asc("productsType.productsType"));
                break;
            case "lengths":
                criteria.setProjection(Projections.distinct(Projections.property("innerLength")));
                criteria.addOrder(Order.asc("innerLength"));
                break;
            case "widths":
                criteria.setProjection(Projections.distinct(Projections.property("innerWidth")));
                criteria.addOrder(Order.asc("innerWidth"));
                break;
            case "heights":
                criteria.setProjection(Projections.distinct(Projections.property("innerHeight")));
                criteria.addOrder(Order.asc("innerHeight"));
                break;
            case "grades":
                criteria.setProjection(Projections.distinct(Projections.property("cardboardBrand.cardboardBrand")));
                criteria.addOrder(Order.asc("cardboardBrand.cardboardBrand"));
                break;
            case "profiles":
                criteria.setProjection(Projections.distinct(Projections.property("profile.profile")));
                criteria.addOrder(Order.asc("profile.profile"));
                break;
            case "colours":
                criteria.setProjection(Projections.distinct(Projections.property("colour")));
                criteria.addOrder(Order.asc("colour"));
                break;
            case "prints":
                criteria.setProjection(Projections.distinct(Projections.property("print")));
                criteria.addOrder(Order.asc("print"));
                break;
        }
        return criteria.list();
    }

    private Criteria getSortingCriteria(Criteria criteria, ProductRegisterFilter filter) {
        if (filter.getSortableColumn() != null)
            switch (filter.getSortableColumn()) {
                case "ids":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("id"));
                    else
                        criteria.addOrder(Order.desc("id"));
                    break;
                case "clients":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("client.companyName"));
                    else
                        criteria.addOrder(Order.desc("client.companyName"));
                    break;
                case "names":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("productsName"));
                    else
                        criteria.addOrder(Order.desc("productsName"));
                    break;
                case "types":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("productsType.productsType"));
                    else
                        criteria.addOrder(Order.desc("productsType.productsType"));
                    break;
                case "lengths":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("innerLength"));
                    else
                        criteria.addOrder(Order.desc("innerLength"));
                    break;
                case "widths":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("innerWidth"));
                    else
                        criteria.addOrder(Order.desc("innerWidth"));
                    break;
                case "heights":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("innerHeight"));
                    else
                        criteria.addOrder(Order.desc("innerHeight"));
                    break;
                case "grades":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("grade"));
                    else
                        criteria.addOrder(Order.desc("grade"));
                    break;
                case "profiles":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("profile.profile"));
                    else
                        criteria.addOrder(Order.desc("profile.profile"));
                    break;
                case "colours":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("colour"));
                    else
                        criteria.addOrder(Order.desc("colour"));
                    break;
                case "prints":
                    if (filter.getSortingDirection().equals("asc"))
                        criteria.addOrder(Order.asc("print"));
                    else
                        criteria.addOrder(Order.desc("print"));
                    break;
            }

        return criteria;
    }

    private Criteria getFilterCriteria(ProductRegisterFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProductRegister.class, "product");
        criteria.createAlias("product.client", "client");
        criteria.createAlias("product.cardboardBrand", "cardboardBrand");
        criteria.createAlias("product.productsType", "productsType");
        criteria.createAlias("product.profile", "profile");
        if (!filter.isEmpty()) {
            if (!filter.getIds().isEmpty()) {
                criteria.add(Restrictions.in("product.id", filter.getIds()));
            }
            if (!filter.getClients().isEmpty()) {
                criteria.add(Restrictions.in("client.companyName", filter.getClients()));
            }
            if (!filter.getNames().isEmpty()) {
                criteria.add(Restrictions.in("product.productsName", filter.getNames()));
            }
            if (!filter.getTypes().isEmpty()) {
                criteria.add(Restrictions.in("productsType.productsType", filter.getTypes()));
            }
            if (!filter.getLengths().isEmpty()) {
                criteria.add(Restrictions.in("product.innerLength", filter.getLengths()));
            }
            if (!filter.getWidths().isEmpty()) {
                criteria.add(Restrictions.in("product.innerWidth", filter.getWidths()));
            }
            if (!filter.getHeights().isEmpty()) {
                criteria.add(Restrictions.in("product.innerHeight", filter.getHeights()));
            }
            if (!filter.getGrades().isEmpty()) {
                criteria.add(Restrictions.in("cardboardBrand.cardboardBrandID", filter.getGrades()));
            }
            if (!filter.getProfiles().isEmpty()) {
                criteria.add(Restrictions.in("profile.profile", filter.getProfiles()));
            }
            if (!filter.getColours().isEmpty()) {
                criteria.add(Restrictions.in("product.colour", filter.getColours()));
            }
            if (!filter.getPrints().isEmpty()) {
                criteria.add(Restrictions.in("product.print", filter.getPrints()));
            }
        }
        return criteria;
    }
}
