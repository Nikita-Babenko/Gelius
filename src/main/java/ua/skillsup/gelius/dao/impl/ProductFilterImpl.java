package ua.skillsup.gelius.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductFilter;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsSearchFilter;
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
    public List<ProductDto> findByFilter(ProductsSearchFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        List<Product> products = criteria.list();
        if (!filter.isEmpty()) {
            List<String> clients = filter.getClients();
            for (Product product : products){
                for (String client : clients){
                    if (product.getClient().getCompanyName().equals(client)){
                        criteria.add(Restrictions.eq("client", product.getClient()));
                    }
                }
            }
            List<String> names = filter.getNames();
            for (Product product : products){
                for (String name : names){
                    if (product.getProductsName().equals(name)){
                        criteria.add(Restrictions.eq("product_name", product.getProductsName()));
                    }
                }
            }
            List<String> types = filter.getTypes();
            for (Product product : products){
                for (String type : types){
                    if (product.getProductsType().equals(type)){
                        criteria.add(Restrictions.eq("product_type", product.getProductsType()));
                    }
                }
            }
            List<Integer> lengths = filter.getLengths();
            for (Product product : products){
                for (Integer length : lengths){
                    if (product.getInnerLength().equals(length)){
                        criteria.add(Restrictions.eq("inner_length", product.getInnerLength()));
                    }
                }
            }
            List<Integer> widths = filter.getWidths();
            for (Product product : products){
                for (Integer width : widths){
                    if (product.getInnerWidth().equals(width)){
                        criteria.add(Restrictions.eq("inner_width", product.getInnerWidth()));
                    }
                }
            }
            List<Integer> heights = filter.getHeights();
            for (Product product : products){
                for (Integer height : heights){
                    if (product.getInnerHeight().equals(height)){
                        criteria.add(Restrictions.eq("inner_height", product.getInnerHeight()));
                    }
                }
            }
            List<String> grades = filter.getGrades();
            for (Product product : products){
                for (String grade : grades){
                    if (product.getGrade().equals(grade)){
                        criteria.add(Restrictions.eq("grade", product.getGrade()));
                    }
                }
            }
            List<String> profiles = filter.getProfiles();
            for (Product product : products){
                for (String profile : profiles){
                    if (product.getProfile().equals(profile)){
                        criteria.add(Restrictions.eq("profile", product.getProfile()));
                    }
                }
            }
            List<String> colours = filter.getColours();
            for (Product product : products){
                for (String colour : colours){
                    if (product.getColour().equals(colour)){
                        criteria.add(Restrictions.eq("colour", product.getColour()));
                    }
                }
            }
            List<String> prints = filter.getPrints();
            for (Product product : products){
                for (String print : prints){
                    if (product.getPrint().equals(print)){
                        criteria.add(Restrictions.eq("print", product.getPrint()));
                    }
                }
            }
        }
        products = criteria.list();
        List<ProductDto> result = new ArrayList<ProductDto>(products.size());
        for (Product product : products) {
            result.add(convert(product));
        }
        return result;
    }
}
