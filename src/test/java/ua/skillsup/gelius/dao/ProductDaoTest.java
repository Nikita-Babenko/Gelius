package ua.skillsup.gelius.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.configs.HibernateTestConfig;
import ua.skillsup.gelius.configs.TestConfig;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsFilteringAndSortingDTO;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateTestConfig.class, TestConfig.class})
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testFindAll() throws Exception {
        int actualNumber = productDao.findAll().size();

        assertTrue("PRODUCTS table should contain any rows", actualNumber > 0);
    }

    @Test
    public void testFindByFilter() throws Exception {
        List<ProductDto> filteredProducts;
        ProductsFilteringAndSortingDTO searchFilter = new ProductsFilteringAndSortingDTO();

        searchFilter.setClients(Arrays.asList("Ласунка"));
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 4 products with client - \"Ласунка\"", 4, filteredProducts.size());

        searchFilter.setClients(Arrays.asList("Ласунка", "АВК"));
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 5 products (4 - \"Ласунка\" and 1 - \"АВК\") ", 5, filteredProducts.size());

        searchFilter.setWidths(Arrays.asList(300));
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 3 products (2 - \"Ласунка\" and 1 - \"АВК\") ", 3, filteredProducts.size());

        searchFilter.setHeights(Arrays.asList(180));
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 2 products (1 - \"Ласунка\" and 1 - \"АВК\") ", 2, filteredProducts.size());

    }
}