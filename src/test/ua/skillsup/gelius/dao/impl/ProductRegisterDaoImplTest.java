package ua.skillsup.gelius.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"classpath*:spring/mock-mvc-dispatcher-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Repository
public class ProductRegisterDaoImplTest {

    @Autowired
    private ProductRegisterDao productRegisterDao;

    private ProductRegisterFilter productRegisterFilter;

    @Before
    public void setUp() throws Exception {
        productRegisterFilter = new ProductRegisterFilter();
    }

    @Test
    public void get_All_Products() throws Exception {
        List<ProductRegisterDto> allProducts = productRegisterDao.getAllProducts();
        assertEquals(allProducts.size(), 7);
    }

    @Test
    public void find_By_Filter_Only_Lasunka_On_English() throws Exception {
        productRegisterFilter.setClientNames(Arrays.asList("Lasunka"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        List<ProductRegisterDto> byFilterClientEnglish = productRegisterDao.findByFilter(productRegisterFilter);
        assertEquals(byFilterClientEnglish.size(), 3);
    }

}