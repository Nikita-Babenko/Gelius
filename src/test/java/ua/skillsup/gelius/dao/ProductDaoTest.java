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
    public void setUp(){
        filteredProducts = new ArrayList<>();
        searchFilter = new ProductsFilteringAndSortingDTO();
    }

    @After
    public void cleanDate(){
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
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 4 products with client - \"Ласунка\"", 4, filteredProducts.size());
    }

    @Test
    @Ignore
    public void testFindByFilterLasunkaAndAVK() throws Exception {
        searchFilter.setClients(Arrays.asList("Ласунка", "АВК"));
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 5 products (4 - \"Ласунка\" and 1 - \"АВК\") ", 5, filteredProducts.size());
    }

    @Test
    public void testFindByFilterWidth() throws Exception {
        //searchFilter.setClients(Arrays.asList("Ласунка", "АВК"));
        searchFilter.setWidths(Arrays.asList(300));
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 3 products (2 - \"Ласунка\" and 1 - \"АВК\") ", 4, filteredProducts.size());
    }

    @Test
    public void testFindByFilterHeight() throws Exception {
        searchFilter.setHeights(Arrays.asList(180));
        filteredProducts = productDao.findByFilter(searchFilter);
        assertEquals("We should have 2 products (1 - \"Ласунка\" and 1 - \"АВК\") ", 2, filteredProducts.size());

    }
    /*@Test
    public void testGetAll(){
        searchFilter.setHeights(Arrays.asList(180));
        List<ProductDto> dtoList;
        dtoList = productDao.findAll();
        for (ProductDto productDto : dtoList){
            System.out.println("It's all products ");
            System.out.println(productDto.toString());
        }
        dtoList = productDao.findByFilter(searchFilter);
        for (ProductDto productDto : dtoList){
            System.out.println("It's filtered products ");
            System.out.println(productDto.toString());
        }
    }
    @Test
    public void testSortDesc(){
        filteredProducts = (List<ProductDto>)productDao.findFilterParameters(searchFilter, "clients");
        for (ProductDto filter : filteredProducts){
            System.out.println("It's filtered register of products ");
            System.out.println(filter.toString());
        }

    }*/
}