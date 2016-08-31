package ua.skillsup.gelius.dao.impl;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.entity.Product;
import ua.skillsup.gelius.dao.entity.WorkabilityNotes;
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
    public List<ProductDto> getAllProducts() {
        List<Product> productList = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
        List<ProductDto> productDtoList = new ArrayList<>(productList.size());
        productList.forEach(product -> productDtoList.add(modelMapper.map(product, ProductDto.class)));
        return productDtoList;
    }

    @Override
    public long create(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        assignProductToWorkabilityNotes(product);
        this.sessionFactory.getCurrentSession().persist(product);
        return product.getId();
    }

    private void assignProductToWorkabilityNotes(Product product) {
        List<WorkabilityNotes> workabilityNotes = product.getWorkabilityNotes();
        workabilityNotes.forEach(workabilityNote -> workabilityNote.setProduct(product));
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
        Product product = this.sessionFactory.getCurrentSession().get(Product.class, productId);
        return modelMapper.map(product, ProductDto.class);
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
