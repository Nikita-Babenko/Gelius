package ua.skillsup.gelius.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.configs.HibernateTestConfig;
import ua.skillsup.gelius.configs.TestConfig;
import ua.skillsup.gelius.dto.ProductDto;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateTestConfig.class, TestConfig.class})
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testGetAllProducts() throws Exception {
        int actualNumber = productService.getAllProducts().size();
        ProductDto product = new ProductDto();
        productService.createProduct(product);

        int expectedNumber = productService.getAllProducts().size();

        assertEquals("We added one object, thus we have deference: 1",1, expectedNumber - actualNumber);
    }

    @Test
    public void testCreateProduct(){
        ProductDto product = new ProductDto();
        productService.createProduct(product);
        int expected = 6;
        int actual = productService.getAllProducts().size();

        productService.getAllProducts().forEach(k->System.out.println(k.toString()));

        assertEquals("PRODUCT table must contains 6 elements after creating new product",expected,actual);
    }

    @Test
    public void testUpdateProduct(){
        ProductDto product = new ProductDto();
        product.setColour("бел/бел");
        productService.createProduct(product);

        product.setColour("бур/бур");
        productService.editProduct(product);

        String secondColor = productService
                .getAllProducts()
                .get(productService.getAllProducts().size()-1)
                .getColour();

        assertEquals("I updated color in last product, I can check it",true,secondColor.equals("бур/бур"));
    }

    @Test
    public void testFindById(){
        String firstColor = "бел/крас";

        ProductDto product = new ProductDto();
        product.setColour(firstColor);
        productService.createProduct(product);

        long lastAdded = productService.getAllProducts().size();
        product = productService.findById(lastAdded);

        assertEquals("I added product with color бел/крас, find him and check the color",true, firstColor.equals(product.getColour()));
    }

    @Test
    public void testDeleteProduct(){
        int beforeDeleting = productService.getAllProducts().size();

        Long lastId = productService.findById((long) beforeDeleting).getId();
        productService.deleteProduct(lastId);

        int afterDeleting = productService.getAllProducts().size();

        assertEquals("I deleted one product, thus we have deference: 1", 1 , beforeDeleting - afterDeleting);
    }
}