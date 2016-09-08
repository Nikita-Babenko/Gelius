package ua.skillsup.gelius.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.entity.Product;
import ua.skillsup.gelius.model.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mock-mvc-dispatcher-servlet.xml")
@Transactional
public class ProductDaoImplTest {

    @Autowired
    @InjectMocks
    private ProductDao productDao;

    @Autowired
    private ModelMapper modelMapper;

    private ProductDto newProductFirst;
    private ProductDto newProductSecond;
    private ProductDto oldProduct;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Product newProductFirst = new Product();
        newProductFirst.setId(22L);
        newProductFirst.setProductNumber(223);
        newProductFirst.setNew(true);
        newProductFirst.setBlankFormat(200);
        newProductFirst.setWorkabilityNotes(new ArrayList<>());
        this.newProductFirst = modelMapper.map(newProductFirst, ProductDto.class);

        Product newProductSecond = new Product();
        newProductSecond.setId(245L);
        newProductSecond.setProductNumber(343);
        newProductSecond.setNew(true);
        newProductSecond.setProductName("New Product Test2");
        newProductSecond.setBlankFormat(150);
        newProductSecond.setWorkabilityNotes(new ArrayList<>());
        this.newProductSecond = modelMapper.map(newProductSecond, ProductDto.class);

        Product oldProduct = new Product();
        oldProduct.setId(234L);
        oldProduct.setProductNumber(122);
        oldProduct.setNew(false);
        oldProduct.setProductName("New Product Test2");
        oldProduct.setBlankFormat(150);
        oldProduct.setWorkabilityNotes(new ArrayList<>());
        this.oldProduct = modelMapper.map(oldProduct, ProductDto.class);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductDto> allProducts = productDao.findAll();

        assertEquals("Find all products in the database :", allProducts.size(), 7);
    }

    @Test
    public void findAllProductsAfterSaveProduct() throws Exception {
        productDao.save(newProductFirst);
        List<ProductDto> allProducts = productDao.findAll();
        productDao.delete(newProductFirst);

        assertEquals("Find all products after save singe Product", allProducts.size(), 8);
    }

    @Test
    public void getMaxProductNumberForNewProduct() throws Exception {
        productDao.save(newProductFirst);
        int maxProductNumber = productDao.getMaxProductNumber();
        productDao.delete(newProductFirst);

        assertEquals("Get max product number", maxProductNumber, 223);
    }

    @Test
    public void getMaxProductNumberAfterSaveMoreNumberForNewProduct() throws Exception {
        int maxProductNumber;
        productDao.save(newProductFirst);
        maxProductNumber = productDao.getMaxProductNumber();
        assertEquals("Get max product number", maxProductNumber, 223);

        productDao.save(newProductSecond);
        maxProductNumber = productDao.getMaxProductNumber();
        assertEquals("Get max product number", maxProductNumber, 343);

        productDao.delete(newProductFirst);
        productDao.delete(newProductSecond);
    }

    @Test
    public void oldProductExist() throws Exception {
        productDao.save(oldProduct);
        boolean isExist = productDao.isProductExist(oldProduct.getProductNumber());
        productDao.delete(oldProduct);
        assertEquals("Old product exist", isExist, true);
    }

    @Test
    public void oldProductIsNotExist() throws Exception {
        boolean isExist = productDao.isProductExist(1233);

        assertEquals("Old product isn't exist", isExist, false);
    }

    @Test
    public void findProductById() throws Exception {
        ProductDto product = productDao.findById(3);

        assertEquals("Find product bu id", product.getId(), new Long(3));
    }
}