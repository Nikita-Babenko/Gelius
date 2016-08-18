package ua.skillsup.gelius.dao.impl;


import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.model.entity.Product;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:*/spring/mock-mvc-dispatcher-servlet.xml")
@Transactional
public class RegisterProductDAOTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductRegisterDao productRegisterDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    // TODO remove @Ignore when test DB were fixed
    @Ignore
    @Test
    public void testAllProductsShownInRegister() throws Exception {
        // count all products
        int numberOfProds = sessionFactory.getCurrentSession().createCriteria(Product.class).list().size();

        // count products from register
        int numberOfProdsRegister = productRegisterDao.findByFilter(new ProductRegisterFilter()).size();

        //Then
        assertEquals(
                "Number of products in register not equal total number of products",
                numberOfProds,
                numberOfProdsRegister
        );

    }

}
