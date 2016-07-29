package ua.skillsup.gelius.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.entities.Client;
import ua.skillsup.gelius.dao.entities.Product;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsFilteringAndSortingDTO;
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
        for (Product product : products) {
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

        if (product == null) {
            return null;
        } else {
            return convert(product);
        }
    }

    @Override
    public List<ProductDto> findByClient(Client client) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : products) {
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
        if (product == null) {
            return null;
        } else {
            return convert(product);
        }

    }

    @Override
    public List<ProductDto> findByGrade(String grade) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select g from Product g where g.grade = :grade").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products) {
            if (product.getGrade().equals(grade))
                result.add(convert(product));
        }
        return result;

    }

    @Override
    public List<ProductDto> findByProfile(String profile) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select p from Product p where p.profile = :profile").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products) {
            if (product.getProfile().equals(profile))
                result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> findByColour(String colour) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select c from Product c where c.colour = :colour").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products) {
            if (product.getColour().equals(colour))
                result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> findByActivity(Character activity) {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("select a from Product a where a.activity = :activity").list();
        List<ProductDto> result = new ArrayList<>(products.size());
        for (Product product : products) {
            if (product.getActivity().equals(activity))
                result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> findByFilter(ProductsFilteringAndSortingDTO filter) {
        Criteria criteria = getFilterCriteria(filter);
        criteria.addOrder(Order.asc("id"));
        List<Product> products = criteria.list();
        List<ProductDto> result = new ArrayList<ProductDto>(products.size());
        for (Product product : products) {
            result.add(convert(product));
        }
        return result;
    }

    @Override
    public List findFilterParameters(ProductsFilteringAndSortingDTO filter, String filterName) {
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
                criteria.setProjection(Projections.distinct(Projections.property("productsType")));
                criteria.addOrder(Order.asc("productsType"));
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
                criteria.setProjection(Projections.distinct(Projections.property("grade")));
                criteria.addOrder(Order.asc("grade"));
                break;
            case "profiles":
                criteria.setProjection(Projections.distinct(Projections.property("profile")));
                criteria.addOrder(Order.asc("profile"));
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

    @Override
    public List<ProductDto> sortingBySelectionOrderAsc(ProductsSortingDTO sorting) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        if (sorting.notNull()) {
            if (sorting.getClient() != null) {
                criteria.addOrder(Order.asc(sorting.getClient()));
            }
            if (sorting.getProductsName() != null) {
                criteria.addOrder(Order.asc(sorting.getProductsName()));
            }
            if (sorting.getProductsType() != null) {
                criteria.addOrder(Order.asc(sorting.getProductsType()));
            }
            if (sorting.getInnerLength() != null) {
                criteria.addOrder(Order.asc(sorting.getInnerLength().toString()));
            }
            if (sorting.getInnerWidth() != null) {
                criteria.addOrder(Order.asc(sorting.getInnerWidth().toString()));
            }
            if (sorting.getInnerHeight() != null) {
                criteria.addOrder(Order.asc(sorting.getInnerHeight().toString()));
            }
            if (sorting.getGrade() != null) {
                criteria.addOrder(Order.asc(sorting.getGrade()));
            }
            if (sorting.getProfile() != null) {
                criteria.addOrder(Order.asc(sorting.getProfile()));
            }
            if (sorting.getColour() != null) {
                criteria.addOrder(Order.asc(sorting.getColour()));
            }
            if (sorting.getPrint() != null) {
                criteria.addOrder(Order.asc(sorting.getPrint()));
            }
        }
        List<Product> products = criteria.list();
        List<ProductDto> result = new ArrayList<ProductDto>(products.size());
        for (Product product : products) {
            result.add(convert(product));
        }
        return result;
    }

    @Override
    public List<ProductDto> sortingBySelectionOrderDesc(ProductsSortingDTO sorting) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        if (sorting.notNull()) {
            if (sorting.getClient() != null) {
                criteria.addOrder(Order.desc(sorting.getClient()));
            }
            if (sorting.getProductsName() != null) {
                criteria.addOrder(Order.desc(sorting.getProductsName()));
            }
            if (sorting.getProductsType() != null) {
                criteria.addOrder(Order.desc(sorting.getProductsType()));
            }
            if (sorting.getInnerLength() != null) {
                criteria.addOrder(Order.desc(sorting.getInnerLength().toString()));
            }
            if (sorting.getInnerWidth() != null) {
                criteria.addOrder(Order.desc(sorting.getInnerWidth().toString()));
            }
            if (sorting.getInnerHeight() != null) {
                criteria.addOrder(Order.desc(sorting.getInnerHeight().toString()));
            }
            if (sorting.getGrade() != null) {
                criteria.addOrder(Order.desc(sorting.getGrade()));
            }
            if (sorting.getProfile() != null) {
                criteria.addOrder(Order.desc(sorting.getProfile()));
            }
            if (sorting.getColour() != null) {
                criteria.addOrder(Order.desc(sorting.getColour()));
            }
            if (sorting.getPrint() != null) {
                criteria.addOrder(Order.desc(sorting.getPrint()));
            }
        }
        List<Product> products = criteria.list();
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
                .setParameter("id", id)
                .uniqueResult();

        sessionFactory.getCurrentSession().delete(product);

    }

    private Criteria getFilterCriteria(ProductsFilteringAndSortingDTO filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class, "product");
        criteria.createAlias("product.client", "client");
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
                criteria.add(Restrictions.in("product.productsType", filter.getTypes()));
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
                criteria.add(Restrictions.in("product.grade", filter.getGrades()));
            }
            if (!filter.getProfiles().isEmpty()) {
                criteria.add(Restrictions.in("product.profile", filter.getProfiles()));
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
