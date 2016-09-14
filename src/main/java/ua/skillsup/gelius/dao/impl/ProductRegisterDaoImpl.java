package ua.skillsup.gelius.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.dao.entity.ProductRegister;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class ProductRegisterDaoImpl implements ProductRegisterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ModelMapper modelMapper;

    private enum RegisterParameter {
        NUMBER("productNumber"), CLIENT("client.companyName"), NAME("productName"), TYPE("productType.productType"),
        LENGTH("innerLength"), WIDTH("innerWidth"), HEIGHT("innerHeight"), CARDBOARD_BRAND("cardboardBrand.cardboardBrand"),
        PROFILE("profile.profile"), LAYERS("layersColours"), CLICHE("cliche");

        private String fullParameterName;

        RegisterParameter(String fullName) {
            fullParameterName = fullName;
        }

        String getFllParameterName() {
            return fullParameterName;
        }
    }

    @Override
    public List<ProductRegisterDto> findByFilter(ProductRegisterFilter filter) {
        Criteria criteria = findFilterCriteria(filter);
        criteria = findSortingCriteria(criteria, filter);

        List<ProductRegister> productList = criteria.list();
        List<ProductRegisterDto> productDtoList = new ArrayList<>(productList.size());
        productList.forEach(product -> productDtoList.add(modelMapper.map(product, ProductRegisterDto.class)));

        return productDtoList;
    }

    private <T> List<T> findFilterParameters(final ProductRegisterFilter filter, String columnName) {
        Criteria criteria = findFilterCriteria(filter);
        criteria.setProjection(Projections.distinct(Projections.property(columnName)));
        criteria.addOrder(Order.asc(columnName));

        return criteria.list();
    }

    @Override
    public <T> Map<String, List<T>> findAllFilterParameters(ProductRegisterFilter filter) {
        Map<String, List<T>> filterParameters = new HashMap<>();
        for(RegisterParameter p: RegisterParameter.values()) {
            filterParameters.put(p.getFllParameterName(), findFilterParameters(filter, p.getFllParameterName()));
        }

        return filterParameters;
    }

    private Criteria findSortingCriteria(Criteria criteria, ProductRegisterFilter filter) {
        String columnName = filter.getSortableColumn();
        if ("asc".equals(filter.getSortingDirection()))
            criteria.addOrder(Order.asc(columnName));
        else
            criteria.addOrder(Order.desc(columnName));
        return criteria;
    }

    private Criteria findFilterCriteria(ProductRegisterFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProductRegister.class, "product");
        criteria.createAlias("product.client", "client", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("product.cardboardBrand", "cardboardBrand", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("product.productType", "productType", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("product.profile", "profile", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("product.faceLayer", "faceLayer", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("product.innerLayer", "innerLayer", JoinType.LEFT_OUTER_JOIN);
        if (!filter.isEmpty()) {
            if (!filter.getProductNumbers().isEmpty()) {
                criteria.add(Restrictions.in("product.productNumber", filter.getProductNumbers()));
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
            if (!filter.getLayersColours().isEmpty()) {
                criteria.add(Restrictions.in("layersColours", filter.getLayersColours()));
            }
            if (!filter.getCliches().isEmpty()) {
                criteria.add(Restrictions.in("product.cliche", filter.getCliches()));
            }
        }
        return criteria;
    }
}
