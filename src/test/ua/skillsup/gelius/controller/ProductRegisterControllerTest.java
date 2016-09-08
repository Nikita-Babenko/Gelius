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
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.service.ProductRegisterService;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mock-mvc-dispatcher-servlet.xml")
public class ProductRegisterControllerTest {

    @Mock
    @Autowired
    private ProductRegisterService productRegisterService;

    @InjectMocks
    @Autowired
    private ProductRegisterController productRegisterController;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private ProductRegisterFilter productRegisterFilter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        productRegisterFilter = new ProductRegisterFilter();

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void returnPage() throws Exception {
        mockMvc.perform(get("/products/register")).andDo(print())
                .andExpect(handler().handlerType(ProductRegisterController.class))
                .andExpect(handler().methodName("pageRegister"))
                .andExpect(view().name("register"))
                .andExpect(forwardedUrl("/WEB-INF/views/register.jsp"))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllProducts() throws Exception {
        when(productRegisterService.findAll()).thenReturn(new ArrayList<>());

        productRegisterController.findAllProducts();

        verify(productRegisterService, times(1)).findAll();
    }

    @Test
    public void findFilterParameters() throws Exception {
        when(productRegisterService.findAllFilterParameters(productRegisterFilter)).thenReturn(new HashMap<>());

        productRegisterController.findFilterParameters(productRegisterFilter);

        verify(productRegisterService, times(1)).findAllFilterParameters(productRegisterFilter);
    }

    @Test
    public void findByFilter() throws Exception {
        when(productRegisterService.findByFilter(productRegisterFilter)).thenReturn(new ArrayList<>());

        productRegisterController.findByFilter(productRegisterFilter);

        verify(productRegisterService, times(1)).findByFilter(productRegisterFilter);
    }

}