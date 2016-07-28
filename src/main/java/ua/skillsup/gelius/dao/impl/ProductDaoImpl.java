package ua.skillsup.gelius.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.entities.Client;
import ua.skillsup.gelius.dao.entities.Product;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsSearchFilter;
import ua.skillsup.gelius.dto.ProductsSortingDTO;

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
    public List<ProductDto> findByFilter(ProductsSearchFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        if (!filter.isEmpty()) {
            List<String> clients = filter.getClients();
            for (String client : clients){
                if (client!=null) {
                    criteria.add(Restrictions.eq("client", client));
                }
            }
            List<String> names = filter.getNames();
            for (String name : names){
                if (name!=null) {
                    criteria.add(Restrictions.eq("productsName", name));
                }
            }
            List<String> types = filter.getTypes();
            for (String type : types){
                if (type!=null) {
                    criteria.add(Restrictions.eq("productsType", type));
                }
            }
            List<Integer> lengths = filter.getLengths();
            for (Integer length : lengths){
                if (length!=null) {
                    criteria.add(Restrictions.eq("innerLength", length));
                }
            }
            List<Integer> widths = filter.getWidths();
            for (Integer width : widths){
                if (width!=null) {
                    criteria.add(Restrictions.eq("innerWidth", width));
                }
            }
            List<Integer> heights = filter.getHeights();
            for (Integer height : heights){
                if (height!=null) {
                    criteria.add(Restrictions.eq("innerHeight", height));
                }
            }

            List<String> grades = filter.getGrades();
            for (String grade : grades){
                if (grade!=null) {
                    criteria.add(Restrictions.eq("grade", grade));
                }
            }
            List<String> profiles = filter.getProfiles();
            for (String profile : profiles){
                if (profile!=null) {
                    criteria.add(Restrictions.eq("profile", profile));
                }
            }
            List<String> colours = filter.getColours();
            for (String colour : colours){
                if (colour!=null) {
                    criteria.add(Restrictions.eq("colour", colour));
                }
            }
            List<String> prints = filter.getPrints();
            for (String print : prints){
                if (print!=null) {
                    criteria.add(Restrictions.eq("print", print));
                }
            }
        }
        List <Product> products = criteria.list();
        List<ProductDto> result = new ArrayList<ProductDto>(products.size());
        for (Product product : products) {
            result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> sortingBySelectionOrderAsc(ProductsSortingDTO sorting) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        if (sorting.notNull()){
           if (sorting.getClient()!=null){
               criteria.addOrder(Order.asc(sorting.getClient()));
           }
           if (sorting.getProductsName()!=null){
               criteria.addOrder(Order.asc(sorting.getProductsName()));
           }
            if (sorting.getProductsType()!=null){
               criteria.addOrder(Order.asc(sorting.getProductsType()));
           }
            if (sorting.getInnerLength()!=null){
               criteria.addOrder(Order.asc(sorting.getInnerLength().toString()));
           }
            if (sorting.getInnerWidth()!=null){
               criteria.addOrder(Order.asc(sorting.getInnerWidth().toString()));
           }
            if (sorting.getInnerHeight()!=null){
               criteria.addOrder(Order.asc(sorting.getInnerHeight().toString()));
           }
            if (sorting.getGrade()!=null){
                criteria.addOrder(Order.asc(sorting.getGrade()));
            }
            if (sorting.getProfile()!=null){
                criteria.addOrder(Order.asc(sorting.getProfile()));
            }
            if (sorting.getColour()!=null){
                criteria.addOrder(Order.asc(sorting.getColour()));
            }
            if (sorting.getPrint()!=null){
                criteria.addOrder(Order.asc(sorting.getPrint()));
            }
        }
        List <Product> products = criteria.list();
        List<ProductDto> result = new ArrayList<ProductDto>(products.size());
        for (Product product : products) {
            result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> sortingBySelectionOrderDesc(ProductsSortingDTO sorting) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        if (sorting.notNull()){
            if (sorting.getClient()!=null){
                criteria.addOrder(Order.desc(sorting.getClient()));
            }
            if (sorting.getProductsName()!=null){
                criteria.addOrder(Order.desc(sorting.getProductsName()));
            }
            if (sorting.getProductsType()!=null){
                criteria.addOrder(Order.desc(sorting.getProductsType()));
            }
            if (sorting.getInnerLength()!=null){
                criteria.addOrder(Order.desc(sorting.getInnerLength().toString()));
            }
            if (sorting.getInnerWidth()!=null){
                criteria.addOrder(Order.desc(sorting.getInnerWidth().toString()));
            }
            if (sorting.getInnerHeight()!=null){
                criteria.addOrder(Order.desc(sorting.getInnerHeight().toString()));
            }
            if (sorting.getGrade()!=null){
                criteria.addOrder(Order.desc(sorting.getGrade()));
            }
            if (sorting.getProfile()!=null){
                criteria.addOrder(Order.desc(sorting.getProfile()));
            }
            if (sorting.getColour()!=null){
                criteria.addOrder(Order.desc(sorting.getColour()));
            }
            if (sorting.getPrint()!=null){
                criteria.addOrder(Order.desc(sorting.getPrint()));
            }
        }
        List <Product> products = criteria.list();
        List<ProductDto> result = new ArrayList<ProductDto>(products.size());
        for (Product product : products) {
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
