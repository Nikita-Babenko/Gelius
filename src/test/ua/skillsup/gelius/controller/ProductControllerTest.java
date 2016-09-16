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
import ua.skillsup.gelius.service.FileService;
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
    private FileService fileService;

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
        productDto.setProductNumber(1);
        productDto.setIsNew(true);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void returnPageInAddNewProductMode() throws Exception {
        mockMvc.perform(get("/products/newProduct")).andDo(print())
                .andExpect(handler().handlerType(ProductController.class))
                .andExpect(handler().methodName("pageNewProduct"))
                .andExpect(view().name("newProduct"))
                .andExpect(forwardedUrl("/WEB-INF/views/newProduct.jsp"))
                .andExpect(status().isOk());
    }

    @Test
    public void returnPageInEditOrCopyMode() throws Exception {
        mockMvc.perform(get("/products/operation/copy/1")).andDo(print())
                .andExpect(handler().handlerType(ProductController.class))
                .andExpect(handler().methodName("pageProductInEditOrCopyMode"))
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
    public void update() throws Exception {
        String idString = "00001";
        when(productService.getFullProductNumber(productDto.getProductNumber(), productDto.getIsNew())).thenReturn(idString);

        productController.update(productDto);

        verify(productService, times(1)).getFullProductNumber(productDto.getProductNumber(), productDto.getIsNew());
        verify(productService, times(1)).update(productDto);
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
    public void getNumberForEditableProduct() throws Exception {
        int number = 15;
        String idString = "00015";
        when(productService.getFullProductNumber(number, true)).thenReturn(idString);

        productController.getNumberForEditableProduct(number, true);

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
        /*long id = 1;
        String productId = "00001";
        when(productService.findById(id)).thenReturn(productDto);
        when(productService.getFullProductNumber(productDto.getProductNumber(), productDto.getIsNew())).thenReturn(productId);
        when(fileService.findFilePaths(productId)).thenReturn(new ArrayList<>());

        productController.findProductById(id);

        verify(productService, times(1)).findById(id);
        verify(fileService, times(1)).findFilePaths(productId);*/
    }

    @Test
    public void deleteProductById() {
        long id = 1;
        when(productService.delete(1)).thenReturn(anyString());

        productService.delete(id);

        verify(productService, times(1)).delete(id);
    }
}