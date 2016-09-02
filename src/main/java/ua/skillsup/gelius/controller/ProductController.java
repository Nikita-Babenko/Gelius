package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.gelius.controller.response.Response;
import ua.skillsup.gelius.controller.response.ResponseCode;
import ua.skillsup.gelius.exception.ProductExistsException;
import ua.skillsup.gelius.exception.ProductValidationException;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.service.DictionaryService;
import ua.skillsup.gelius.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger("ProductController");

    @Autowired
    private ProductService productService;

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.GET)
    private String pageNewProduct() {
        LOG.info("Open new product page");
        return "newProduct";
    }

    @RequestMapping(value = "/newProduct/saveProduct", method = RequestMethod.POST)
    @ResponseBody
    private Response save(@RequestBody ProductDto product) {
        LOG.info("createProduct. Mapping 'raw' product data:\n" + product);
        String savedProductNumberValue = this.productService.save(product);
        String newProductNumberValue = getFullProductNumber();
        Map<String, String> responseData = new HashMap<>();
        responseData.put("newProductNumber", newProductNumberValue);
        responseData.put("savedProductNumber", savedProductNumberValue);

        return new Response(ResponseCode.OK, responseData);
    }

    @RequestMapping(value = "/newProduct/getNewProductNumber", method = RequestMethod.GET)
    @ResponseBody
    private Response getNumberForNewProduct() {

        LOG.info("Get number for new product");
        String newProductNumberValue = getFullProductNumber();

        return new Response(ResponseCode.OK, newProductNumberValue);
    }

    @RequestMapping(value = "/newProduct/allDictionaries", method = RequestMethod.GET)
    @ResponseBody
    private Response findAllDictionaries() {

        LOG.info("Get all dictionaries");
        Map<String, List<?>> dictionaries = dictionaryService.findAll();

        return new Response(ResponseCode.OK, dictionaries);
    }

    private String getFullProductNumber() {
        int newProductNumber = this.productService.getProductNumber();
        return this.productService.getFullProductNumber(newProductNumber, true);
    }

    @ResponseBody
    @ExceptionHandler(ProductExistsException.class)
    public Response exceptionHandler(ProductExistsException e) {
        LOG.info("ExceptionHandler (ProductExistsException): " + e);
        return new Response(ResponseCode.OBJECT_EXISTS);
    }

    @ResponseBody
    @ExceptionHandler(ProductValidationException.class)
    public Response exceptionHandler(ProductValidationException e) {
        LOG.info("ExceptionHandler (ProductValidationException): " + e);
        List<String> validationErrors = e.getErrors();
        return new Response(ResponseCode.VALIDATION_ERROR, validationErrors);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception e) {
        LOG.info("ExceptionHandler (Exception): " + e);
        return new Response(ResponseCode.SERVER_ERROR);
    }

}
