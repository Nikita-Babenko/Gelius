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
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateTestConfig.class, TestConfig.class})
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testGetAllProducts() throws Exception {
        int actualNumber = productService.getAllProducts().size();

        assertTrue("PRODUCTS table should contain any rows", actualNumber > 0);
    }

    @Test
    public void testCreateProduct() {
        int beforeAddition = productService.getAllProducts().size();
        ProductDto product = new ProductDto();

        productService.createProduct(product);
        int afterAddition = productService.getAllProducts().size();

        assertEquals("One object was added, thus we should have deference: 1", 1, afterAddition - beforeAddition);
    }

    @Test
    public void testUpdateProduct() {
        String expectedColor = "бур/бур";
        ProductDto product = new ProductDto();
        product.setColour("бел/бел");

        long productId = productService.createProduct(product);

        product = productService.findById(productId);
        product.setColour(expectedColor);
        productService.editProduct(product);

        ProductDto editedProduct = productService.findById(productId);
        String actualColor = editedProduct.getColour();

        assertEquals(expectedColor, actualColor);
    }

    @Test
    public void testFindById() {
        ProductDto product = new ProductDto();
        product.setColour("бел/крас");
        long savedProductId = productService.createProduct(product);

        ProductDto lastAdded = productService.
                getAllProducts().
                get(productService.getAllProducts().size() - 1);
        product = productService.findById(savedProductId);

        assertEquals(product, lastAdded);
    }

    @Test
    public void testDeleteProduct() {
        int beforeDeleting = productService.getAllProducts().size();

        Long lastId = productService.findById((long) beforeDeleting).getId();
        productService.deleteProduct(lastId);

        int afterDeleting = productService.getAllProducts().size();

        assertEquals("One product was deleted, thus we should have deference: 1", 1, beforeDeleting - afterDeleting);
    }
}