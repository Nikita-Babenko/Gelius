package ua.skillsup.gelius.dao;

import org.junit.After;
import org.junit.Before;
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
    public void testFindByFilterLasunka() throws Exception {
        searchFilter.setClients(Arrays.asList("Lasunka"));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 4 products with client - \"Lasunka\"", 4, filteredProducts.size());
    }

    @Test
    public void testFindByFilterLasunkaAndAVK() throws Exception {
        searchFilter.setClients(Arrays.asList("Lasunka","ABK"));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 5 products (4 - \"Lasunka\" and 1 - \"ABK\") ", 5, filteredProducts.size());
    }

    @Test
    public void testFindByFilterWidth() throws Exception {
        searchFilter.setClients(Arrays.asList("Lasunka","ABK"));
        searchFilter.setWidths(Arrays.asList(300));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 3 products (2 - \"Lasunka\" and 1 - \"ABK\") ", 3, filteredProducts.size());
    }

    @Test
    public void testFindByFilterHeight() throws Exception {
        searchFilter.setHeights(Arrays.asList(180));
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        assertEquals("We should have 2 products (1 - \"Lasunka\" and 1 - \"ABK\") ", 2, filteredProducts.size());

    }

    @Test
    public void testFindFilterParameters() throws Exception {
        searchFilter.setIds(Arrays.asList(Long.valueOf(2), Long.valueOf(3), Long.valueOf(4)));
        searchFilter.setWidths(Arrays.asList(300));

        List expectedLengths = Arrays.asList(400, 410);
        List actualLengths = productDao.findFilterParameters(searchFilter, "lengths");

        assertEquals(expectedLengths, actualLengths);
    }
    @Test
    public void testSortingByClientsDesc(){
        searchFilter.setSortableColumn("clients");
        searchFilter.setSortingDirection("kuku");//на самом деле написать сюда можно что угодно, кроме asc.
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        for (ProductDto product : filteredProducts){
            int i=0;
            i++;
            if (i==1){
                assertTrue("Sorting is mistakenly", product.getClients().getCompanyName().equals("Petruschenko"));
                break;
            }
        }
    }
    @Test
    public void testSortingByClientsAsc(){
        searchFilter.setSortableColumn("clients");
        searchFilter.setSortingDirection("asc");
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        for (ProductDto product : filteredProducts){
            int i=0;
            i++;
            if (i==1){
                assertTrue("Sorting is mistakenly", product.getClients().getCompanyName().equals("ABK"));
                break;
            }
        }
    }
    @Test
    public void testSortingByClientsDescWithFilter(){
        searchFilter.setClients(Arrays.asList("Lasunka","ABK"));
        searchFilter.setSortableColumn("clients");
        searchFilter.setSortingDirection("desc");
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        for (ProductDto product : filteredProducts){
            int i=0;
            i++;
            if (i==1){
                assertTrue("Sorting is mistakenly", product.getClients().getCompanyName().equals("Lasunka"));
                break;
            }
        }
    }
    @Test
    public void testSortingByHeightAscWithFilter(){
        searchFilter.setClients(Arrays.asList("ABK","Petruschenko"));
        searchFilter.setSortableColumn("heights");
        searchFilter.setSortingDirection("asc");
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        for (ProductDto product : filteredProducts){
            int i=0;
            i++;
            if (i==1){
                assertTrue("Sorting is mistakenly", product.getInnerHeight() == 130);
                break;
            }
        }
    }
    @Test
    public void testSortingByHeightDescWithFilter(){
        searchFilter.setClients(Arrays.asList("ABK","Petruschenko"));
        searchFilter.setSortableColumn("heights");
        searchFilter.setSortingDirection("desc");
        filteredProducts = productDao.findByFilterAndSorting(searchFilter);
        for (ProductDto product : filteredProducts){
            int i=0;
            i++;
            if (i==1){
                assertTrue("Sorting is mistakenly", product.getInnerHeight() == 180);
                break;
            }
        }
    }

}