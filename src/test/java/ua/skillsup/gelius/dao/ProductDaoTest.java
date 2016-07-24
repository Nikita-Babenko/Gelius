package ua.skillsup.gelius.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.configs.HibernateTestConfig;
import ua.skillsup.gelius.configs.TestConfig;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateTestConfig.class, TestConfig.class})
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testFindAll() throws Exception {
        int expectedNumber = 5;
        int actualNuber = productDao.findAll().size();

        assertEquals("PRODUCTS table should contain 5 rows", expectedNumber, actualNuber);
    }
}