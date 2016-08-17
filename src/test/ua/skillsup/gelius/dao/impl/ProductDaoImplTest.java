package ua.skillsup.gelius.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.ClientDto;
import ua.skillsup.gelius.model.entity.Product;

import static org.junit.Assert.*;
import static ua.skillsup.gelius.model.convert.ProductConvert.convert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/mock-mvc-dispatcher-servlet.xml")
@Transactional
//@Rollback(true)
public class ProductDaoImplTest {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {

        Session session = this.sessionFactory.getCurrentSession();

        //Given
        ProductDto product = createProduct();
        long count = getProductCountFromDatabase();

        //When
        long productId = this.productDao.create(product);
        Product savedProduct = (Product) session.
            get(Product.class, productId);
        long countActual = getProductCountFromDatabase();

        //Then
        assertTrue("Продукт не сохранен, т.к. его Id меньше либо равен нулю.", productId > 0);
        assertEquals("Количество продуктов не увеличилось на 1", count + 1, countActual);
        assertEquals(
            "Сохранились не те данные (client).",
            product.getClient().getId(),
            savedProduct.getClient().getId()
        );

    }

    @Test
    public void testGetMaxProductNumberOfNewDatasheets() throws Exception {
        //Given
        int maxProductNumberExpected = (int) this.sessionFactory.getCurrentSession().
            createQuery("select max(p.productNumber) from Product p where p.isNew=true").
            uniqueResult();

        //When
        int maxProductNumber = this.productDao.getMaxProductNumberOfNewDatasheets();

        //Then
        assertEquals(
            "Не совпадает максимальный номер существующих новых техкарт",
            maxProductNumberExpected,
            maxProductNumber
        );
    }

    @Test
    public void testFindById() throws Exception {
        //Given
        ProductDto productDtoExpected = createProduct();
        Product product = convert(productDtoExpected);
        this.sessionFactory.getCurrentSession().persist(product);

        //When
        ProductDto productDtoActual = this.productDao.findById(product.getId());

        //Then
        assertNotNull("Продукт не найден", productDtoActual);
        assertEquals(
            "Найден не тот продукт (сравнили по Id клиента)",
            productDtoExpected.getClient().getId(),
            productDtoActual.getClient().getId()
        );
    }


    private long getProductCountFromDatabase() {
        return (long) this.sessionFactory.getCurrentSession().
            createQuery("select count(p) from Product p").
            uniqueResult();
    }

    private ProductDto createProduct() {
        ProductDto product = new ProductDto();
        Long clientId = 1L;
        product.setClient( new ClientDto(clientId));
        product.setBlankFormat(42);
        product.setIsNew(false);
        product.setProductNumber(1845);
        return product;
    }

}