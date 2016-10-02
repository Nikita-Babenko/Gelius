package ua.skillsup.gelius.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.util.ProductTestUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mock-mvc-dispatcher-servlet.xml")
@Transactional
public class ProductRegisterDaoImplTest {

    @Autowired
    private ProductRegisterDao productRegisterDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ModelMapper modelMapper;

    private ProductRegisterFilter productRegisterFilter;

    private List<ProductDto> products;

    private List<Long> productIds;

    @Before
    public void setUp() throws Exception {
        productRegisterFilter = new ProductRegisterFilter();

        products = new ArrayList<ProductDto>(){{

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(1, true, "Product 1", 2, 12d, 200, 50, 140, 1),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(1, false, "Product 2", 2, 15d, 100, 75, 188, 1),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(567, false, "Product 3", 1, 45d, 324, 44, 124, 2),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(14, true, "Product 4", 4, 8d, 200, 89, 255, 3),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(45, false, "Product 5", 4, 8d, 415, 30, 90, 4),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(2, false, "Product 6", 2, 9d, 200, 46, 145, 5),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(34, false, "Product 7", 3, 9d, 200, 66, 167, 4),
                    ProductDto.class));
        }};

        productIds = new ArrayList<>();
        products.forEach(productDto -> productIds.add(productDao.save(productDto)));
    }

    @After
    public void tearDown() throws Exception {
        productIds.forEach(aLong -> productDao.delete(aLong));
    }

    @Test
    public void sortAllProductsByIdAsc() throws Exception {
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("id");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long id = byFilter.get(0).getId();
        long currentId = productDao.findById(id).getId();

        assertEquals("Sort all product by id, asc", id, currentId);
    }

    @Test
    public void sortAllProductsByIdDesc() throws Exception {
        productRegisterFilter.setSortingDirection("desc");
        productRegisterFilter.setSortableColumn("id");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long id = byFilter.get(0).getId();
        long currentId = productDao.findById(id).getId();

        assertEquals("Sort all product by id, desc", id, currentId);
    }

    @Test
    public void sortAllProductsByInnerWidthAsc() throws Exception {
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("innerWidth");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long innerWidth = byFilter.get(0).getInnerWidth();

        assertEquals("Sort all product by inner width, asc", innerWidth, 100);
    }

    @Test
    public void sortAllProductsByInnerWidthDesc() throws Exception {
        productRegisterFilter.setSortingDirection("desc");
        productRegisterFilter.setSortableColumn("innerWidth");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long innerWidth = byFilter.get(0).getInnerWidth();

        assertEquals("Sort all product by inner width, desc", innerWidth, 415);
    }

    @Test
    public void sortAllProductsByInnerHeightAsc() throws Exception {
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("innerHeight");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long innerHeight = byFilter.get(0).getInnerHeight();

        assertEquals("Sort all product by inner height, asc", innerHeight, 30);
    }

    @Test
    public void sortAllProductsByInnerHeightDesc() throws Exception {
        productRegisterFilter.setSortingDirection("desc");
        productRegisterFilter.setSortableColumn("innerHeight");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long innerHeight = byFilter.get(0).getInnerHeight();

        assertEquals("Sort all product by inner height, desc", innerHeight, 89);
    }

    @Test
    public void sortAllProductsByInnerLengthAsc() throws Exception {
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("innerLength");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long innerHeight = byFilter.get(0).getInnerLength();

        assertEquals("Sort all product by inner length, asc", innerHeight, 90);
    }

    @Test
    public void sortAllProductsByInnerLengthDesc() throws Exception {
        productRegisterFilter.setSortingDirection("desc");
        productRegisterFilter.setSortableColumn("innerLength");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long innerHeight = byFilter.get(0).getInnerLength();

        assertEquals("Sort all product by inner length, desc", innerHeight, 255);
    }

    @Test
    public void findProductsWithDifferentNamesInEnglishSortByIdAsc() throws Exception {
        productRegisterFilter.setProductNames(Arrays.asList("Product 1", "Product 4", "Product 3"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("id");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long id = byFilter.get(0).getId();
        long currentId = productDao.findById(id).getId();

        assertEquals("Find products with different names and sort by id, asc", byFilter.size(), 3);
        assertEquals("After sorting", id, currentId);
    }

    @Test
    public void findProductsWithDifferentNamesInEnglishSortByIdDesc() throws Exception {
        productRegisterFilter.setProductNames(Arrays.asList("Product 1", "Product 4", "Product 3", "Product 5"));
        productRegisterFilter.setSortingDirection("desc");
        productRegisterFilter.setSortableColumn("id");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        long id = byFilter.get(0).getId();
        long currentId = productDao.findById(id).getId();

        assertEquals("Find products with different names and sort by id, asc", byFilter.size(), 4);
        assertEquals("After sorting", id, currentId);
    }

    @Test
    public void findProductsBySameClientsInEnglish() throws Exception {
        productRegisterFilter.setClientNames(Collections.singletonList("Lasunka"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find products by same client", byFilter.size(), 3);
    }

    @Test
    public void findProductsBySameClientsInRussian() throws Exception {
        productRegisterFilter.setClientNames(Collections.singletonList("Ласунка"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find products by same client", byFilter.size(), 2);
    }

    @Test
    public void findProductsByDifferentClientsMixed() throws Exception {
        productRegisterFilter.setClientNames(Arrays.asList("Ласунка", "Lasunka", "АВК"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find products by different client", byFilter.size(), 6);
    }

    @Test
    public void findProductsBySameClientsInnerWidthInEnglishSortByClientAsc() throws Exception {
        productRegisterFilter.setClientNames(Collections.singletonList("Lasunka"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        productRegisterFilter.setInnerWidths(Collections.singletonList(200));
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find products which have only same English name and same width", byFilter.size(), 2);
    }

    @Test
    public void findProductsByDifferentClientsByFilterSameWidthInEnglish() throws Exception {
        productRegisterFilter.setClientNames(Arrays.asList("Lasunka", "Petruschenko"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        productRegisterFilter.setInnerWidths(Collections.singletonList(200));
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find products which have different English names and same width", byFilter.size(), 3);
    }

    @Test
    public void findProductsByDifferentClientsByFilterSameWidthInMixed() throws Exception {
        productRegisterFilter.setClientNames(Arrays.asList("Lasunka", "Ласунка"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        productRegisterFilter.setInnerWidths(Collections.singletonList(200));
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find products which have different English names and same width", byFilter.size(), 3);
    }

    @Test
    public void findProductsByDifferentClientsByFilterTwoWidthsInMixed() throws Exception {
        productRegisterFilter.setClientNames(Arrays.asList("Lasunka", "Ласунка"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        productRegisterFilter.setInnerWidths(Arrays.asList(200, 415));
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find products which have different English names and different widths", byFilter.size(), 4);
    }


    @Test
    public void findProductsDifferentClientsFilterTwoWidthsLengthInMixed() throws Exception {
        productRegisterFilter.setClientNames(Arrays.asList("Lasunka", "Ласунка"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        productRegisterFilter.setInnerWidths(Arrays.asList(200, 415));
        productRegisterFilter.setInnerLengths(Collections.singletonList(90));
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find Products with different width, lengths and clients", byFilter.size(), 1);
    }

    @Test
    public void findProductsDifferentClientsFilterOneWidthLengthInRussian() throws Exception {
        productRegisterFilter.setClientNames(Arrays.asList("Петрушенко", "Ласунка"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("client");
        productRegisterFilter.setInnerWidths(Collections.singletonList(200));
        productRegisterFilter.setInnerLengths(Collections.singletonList(255));
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find Products with different width, lengths and clients", byFilter.size(), 1);
    }

    @Test
    public void findProductsSameClientFilterOneWidthCardBoardBrandLengthInEnglish() throws Exception {
        productRegisterFilter.setClientNames(Collections.singletonList("Lasunka"));
        productRegisterFilter.setCardboardBrands(Collections.singletonList("Т-21"));
        productRegisterFilter.setSortingDirection("asc");
        productRegisterFilter.setSortableColumn("id");
        productRegisterFilter.setInnerWidths(Collections.singletonList(200));
        productRegisterFilter.setInnerLengths(Collections.singletonList(140));
        List<ProductRegisterDto> byFilter = productRegisterDao.findByFilter(productRegisterFilter);

        assertEquals("Find Products with different width, lengths and clients", byFilter.size(), 1);
    }

}