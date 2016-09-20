package ua.skillsup.gelius.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.entity.ProducibilityNotes;
import ua.skillsup.gelius.dao.entity.Product;
import ua.skillsup.gelius.model.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductDto> findAll() {
        List<Product> productList = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
        List<ProductDto> productDtoList = new ArrayList<>(productList.size());
        productList.forEach(product -> productDtoList.add(modelMapper.map(product, ProductDto.class)));
        return productDtoList;
    }

    @Override
    public long save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        assignProductToProducibilityNotes(product);
        this.sessionFactory.getCurrentSession().persist(product);
        return product.getId();
    }

    @Override
    public void update(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product.getProducibilityNotes()
                .forEach(producibilityNotes -> this.sessionFactory.getCurrentSession().
                        createQuery("DELETE FROM ProducibilityNotes a " +
                                "WHERE a.product=:product")
                        .setParameter("product", product).executeUpdate());
        sessionFactory.getCurrentSession().merge(product);
    }

    @Override
    public ProductDto delete(long productId) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, productId);
        session.delete(product);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public int getMaxNumberOfNewProduct() {
        Integer maxNumber = (Integer) this.sessionFactory.getCurrentSession().
            createQuery("select max(p.productNumber) from Product p where p.isNew = true").
            uniqueResult();
        return maxNumber == null ? 0 : maxNumber;
    }

    @Override
    public ProductDto findById(long productId) {
        Product product = this.sessionFactory.getCurrentSession().get(Product.class, productId);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public boolean isOldProductExist(int productNumber) {
        long count = (long) this.sessionFactory.getCurrentSession().
            createQuery("select count(p) from Product p where p.productNumber = :productNumber and p.isNew = false").
            setParameter("productNumber", productNumber).
            uniqueResult();
        return count != 0;
    }

    private void assignProductToProducibilityNotes(Product product) {
        List<ProducibilityNotes> producibilityNotes = product.getProducibilityNotes();
        producibilityNotes.forEach(producibilityNote -> producibilityNote.setProduct(product));
    }
}
