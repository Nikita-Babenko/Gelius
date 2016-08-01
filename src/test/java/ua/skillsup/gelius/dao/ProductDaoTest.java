package ua.skillsup.gelius.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.configs.HibernateTestConfig;
import ua.skillsup.gelius.configs.TestConfig;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsFilteringAndSortingDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateTestConfig.class, TestConfig.class})
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;
    private List<ProductDto> filteredProducts;
    private ProductsFilteringAndSortingDTO searchFilter;

    @Before
    public void setUp() {
        filteredProducts = new ArrayList<>();
        searchFilter = new ProductsFilteringAndSortingDTO();
    }

    @After
    public void cleanDate() {
        filteredProducts.clear();
        searchFilter = null;
    }


    @Test
    public void testFindAll() throws Exception {
        int actualNumber = productDao.findAll().size();

        assertTrue("PRODUCTS table should contain any rows", actualNumber > 0);
    }

    @Test
    @Ignore
    public void testFindByFilterLasunka() throws Exception {
        searchFilter.setClients(Arrays.asList("Ласунка"));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 4 products with client - \"Ласунка\"", 4, filteredProducts.size());
    }

    @Test
    @Ignore
    public void testFindByFilterLasunkaAndAVK() throws Exception {
        searchFilter.setClients(Arrays.asList("Ласунка", "АВК"));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 5 products (4 - \"Ласунка\" and 1 - \"АВК\") ", 5, filteredProducts.size());
    }

    @Test
    public void testFindByFilterWidth() throws Exception {
        searchFilter.setClients(Arrays.asList("Ласунка", "АВК"));
        searchFilter.setWidths(Arrays.asList(300));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 3 products (2 - \"Ласунка\" and 1 - \"АВК\") ", 3, filteredProducts.size());
    }

    @Test
    public void testFindByFilterHeight() throws Exception {
        searchFilter.setHeights(Arrays.asList(180));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 2 products (1 - \"Ласунка\" and 1 - \"АВК\") ", 2, filteredProducts.size());

    }

    @Test
    public void testFindFilterParameters() throws Exception {
        searchFilter.setIds(Arrays.asList(Long.valueOf(2), Long.valueOf(3), Long.valueOf(4)));
        searchFilter.setWidths(Arrays.asList(300));

        List expectedLengths = Arrays.asList(400, 410);
        List actualLengths = productDao.findFilterParameters(searchFilter, "lengths");

        assertEquals(expectedLengths, actualLengths);
    }
}