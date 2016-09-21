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

import static org.junit.Assert.*;

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

    private ProductDto newProductDtoFirst;
    private ProductDto newProductDtoSecond;
    private ProductDto oldProductDto;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Product newProductFirst = new Product();
        newProductFirst.setProductNumber(223);
        newProductFirst.setNew(true);
        newProductFirst.setBlankFormat(200);
        newProductFirst.setProducibilityNotes(new ArrayList<>());
        newProductFirst.setBigovki(new ArrayList<>());
        this.newProductDtoFirst = modelMapper.map(newProductFirst, ProductDto.class);

        Product newProductSecond = new Product();
        newProductSecond.setProductNumber(343);
        newProductSecond.setNew(true);
        newProductSecond.setProductName("New Product Test2");
        newProductSecond.setBlankFormat(150);
        newProductSecond.setProducibilityNotes(new ArrayList<>());
        newProductSecond.setBigovki(new ArrayList<>());
        this.newProductDtoSecond = modelMapper.map(newProductSecond, ProductDto.class);

        Product oldProduct = new Product();
        oldProduct.setProductNumber(122);
        oldProduct.setNew(false);
        oldProduct.setProductName("New Product Test2");
        oldProduct.setBlankFormat(150);
        oldProduct.setProducibilityNotes(new ArrayList<>());
        oldProduct.setBigovki(new ArrayList<>());
        this.oldProductDto = modelMapper.map(oldProduct, ProductDto.class);
    }

    @Test
    public void findAll() throws Exception {
        //G
        int productCountExpected = 7;
        //W
        List<ProductDto> allProducts = productDao.findAll();
        //T
        assertEquals("Find all products in the database :", productCountExpected, allProducts.size());
    }

    @Test
    public void findAllProductsAfterSaveProduct() throws Exception {
        //G
        int productCountExpected = 8;
        //W
        long productId = productDao.save(newProductDtoFirst);
        List<ProductDto> allProducts = productDao.findAll();
        //T
        assertEquals("Find all products after save singe Product", productCountExpected, allProducts.size());

        productDao.delete(productId);
    }

    @Test
    public void getMaxProductNumberForNewProduct() throws Exception {
        //G
        int maxProductNumberExpected = 223;
        //W
        long productId = productDao.save(newProductDtoFirst);
        int maxProductNumber = productDao.getMaxNumberOfNewProduct();
        //T
        assertEquals("Get max product number", maxProductNumberExpected, maxProductNumber);

        productDao.delete(productId);
    }

    @Test
    public void getMaxProductNumberAfterSaveMoreNumberForNewProduct() throws Exception {
        //G
        int maxProductNumberExpectedFirst = 223;
        int maxProductNumberExpectedSecond = 343;
        //W
        long productIdFirst = productDao.save(newProductDtoFirst);
        int maxProductNumberFirst = productDao.getMaxNumberOfNewProduct();
        long productIdSecond = productDao.save(newProductDtoSecond);
        int maxProductNumberSecond = productDao.getMaxNumberOfNewProduct();
        //T
        assertEquals("Get max product number", maxProductNumberExpectedFirst, maxProductNumberFirst);
        assertEquals("Get max product number", maxProductNumberExpectedSecond, maxProductNumberSecond);

        productDao.delete(productIdFirst);
        productDao.delete(productIdSecond);
    }

    @Test
    public void oldProductExist() throws Exception {
        //W
        long productId = productDao.save(oldProductDto);
        boolean isExist = productDao.isOldProductExist(oldProductDto.getProductNumber());
        //T
        assertTrue("Old product exist", isExist);

        productDao.delete(productId);
    }

    @Test
    public void oldProductIsNotExist() throws Exception {
        //W
        boolean isExist = productDao.isOldProductExist(1233);
        //T
        assertFalse("Old product isn't exist", isExist);
    }

    @Test
    public void findProductById() throws Exception {
        //G
        long productId = 3L;
        //W
        ProductDto product = productDao.findById(productId);
        //T
        assertEquals("Find product bu id", product.getId(), new Long(productId));
    }
}