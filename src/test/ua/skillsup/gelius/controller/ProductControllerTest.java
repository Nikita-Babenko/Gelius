package ua.skillsup.gelius.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.service.DictionaryService;
import ua.skillsup.gelius.service.ProductService;

import java.util.HashMap;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mock-mvc-dispatcher-servlet.xml")
public class ProductControllerTest {

    @Mock
    @Autowired
    private ProductService productService;

    @Mock
    @Autowired
    private DictionaryService dictionaryService;

    @InjectMocks
    @Autowired
    private ProductController productController;

    private ProductDto productDto;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setIsNew(true);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void returnPage() throws Exception {
        mockMvc.perform(get("/products/newProduct")).andDo(print())
                .andExpect(handler().handlerType(ProductController.class))
                .andExpect(handler().methodName("pageNewProduct"))
                .andExpect(view().name("newProduct"))
                .andExpect(forwardedUrl("/WEB-INF/views/newProduct.jsp"))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {
        when(productService.save(productDto)).thenReturn(String.valueOf(productDto.getId()));

        productController.save(productDto);

        verify(productService, times(1)).save(productDto);
    }

    @Test
    public void getNumberForNewProduct() throws Exception {
        int number = 1;
        String idString = "00001";
        when(productService.getProductNumber()).thenReturn(number);
        when(productService.getFullProductNumber(number, true)).thenReturn(idString);

        productController.getNumberForNewProduct();

        verify(productService, times(1)).getProductNumber();
        verify(productService, times(1)).getFullProductNumber(number, true);
    }

    @Test
    public void getAllDictionaries() throws Exception {
        when(dictionaryService.findAll()).thenReturn(new HashMap<>());

        productController.findAllDictionaries();

        verify(dictionaryService, times(1)).findAll();
    }

    @Test
    public void findById() throws Exception {
        long id = 1;
        when(productService.findById(id)).thenReturn(productDto);

        productController.findProductById(id);

        verify(productService, times(1)).findById(id);
    }

    @Test
    public void deleteProductById() {
        long id = 1;
        when(productService.delete(1)).thenReturn(anyString());

        productService.delete(id);

        verify(productService, times(1)).delete(id);
    }
}