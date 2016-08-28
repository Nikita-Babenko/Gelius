package ua.skillsup.gelius.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.entity.Product;
import ua.skillsup.gelius.dao.entity.WorkabilityNotes;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.util.convert.ProductConvert;

import java.util.List;

import static ua.skillsup.gelius.util.convert.ProductConvert.convert;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductDto> getAllProducts() {
        List<Product> products = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
        return ProductConvert.convertList(products);
    }

    @Override
    public long create(ProductDto productDto) {
        Product product = convert(productDto);
        assignProductToWorkabilityNotes(product);
        this.sessionFactory.getCurrentSession().persist(product);
        return product.getId();
    }

    private void assignProductToWorkabilityNotes(Product product) {
        List<WorkabilityNotes> workabilityNotes = product.getWorkabilityNotes();
        for (int i = 0; i < workabilityNotes.size(); i++) {
            workabilityNotes.get(i).setProduct(product);
        }
    }

    @Override
    public int getMaxProductNumberOfNewDatasheets() {
        Integer maxNumber = (Integer) this.sessionFactory.getCurrentSession().
            createQuery("select max(p.productNumber) from Product p where p.isNew = true").
            uniqueResult();
        return maxNumber == null ? 0 : maxNumber;
    }

    @Override
    //Can returns null if product not found.
    public ProductDto findById(long productId) {
        Product product = (Product) this.sessionFactory.getCurrentSession().get(Product.class, productId);
        return convert(product);
    }

    @Override
    public boolean isExistsOldProductWithSameProductNumber(int productNumber) {
        long count = (long) this.sessionFactory.getCurrentSession().
            createQuery("select count(p) from Product p where p.productNumber = :productNumber and p.isNew = false").
            setParameter("productNumber", productNumber).
            uniqueResult();
        return count != 0;
    }
}
