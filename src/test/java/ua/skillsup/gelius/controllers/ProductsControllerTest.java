package ua.skillsup.gelius.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ua.skillsup.gelius.configs.SpringWebConfig;
import ua.skillsup.gelius.dto.ProductsFilteringAndSortingDTO;
import ua.skillsup.gelius.services.impl.ProductServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = SpringWebConfig.class)
public class ProductsControllerTest {

    @InjectMocks
    ProductsController controller;
    @Mock
    ProductServiceImpl productsService;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testGetProductsByEmptyFilter() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JSONResponse response = new JSONResponse();
        response.setMessage("List of products is empty!");
        response.setCode("204");

        String expected = mapper.writeValueAsString(response);
        System.out.println("Expected : " + expected);

        //actual
        ProductsFilteringAndSortingDTO filter = new ProductsFilteringAndSortingDTO();

        String content = mapper.writeValueAsString(filter);
        System.out.println("content : " + content);

        MvcResult result = mockMvc.perform(post("/products/filtrate").contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andReturn();

        String actual = result.getResponse().getContentAsString();
        System.out.println("Actual : " + actual);

        // assert
        assertEquals(expected, actual);

    }

}
