package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.controller.response.Response;
import ua.skillsup.gelius.controller.response.ResponseCode;
import ua.skillsup.gelius.exception.ProductExistsException;
import ua.skillsup.gelius.exception.ProductValidationException;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.service.DictionaryService;
import ua.skillsup.gelius.service.FileService;
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

    @Autowired
    private FileService fileService;

    private String operationOnProduct;
    private int productId;

    @RequestMapping(value = "/newProduct", method = RequestMethod.GET)
    public String pageNewProduct() {
        LOG.info("Open new product page in [new product] mode");

        operationOnProduct = "new";
        productId = 0;

        return "newProduct";
    }

    @RequestMapping(value = "/{operation}/{productId}", method = RequestMethod.GET)
    public String pageProductInEditOrCopyMode(@PathVariable("operation") String operation, @PathVariable("productId") int id) {
        LOG.info("Open new product page in [" + operation + " product] mode");

        operationOnProduct = operation;
        productId = id;

        return "newProduct";
    }


    /**
     *
     * @return id of product and operation name that will be executed on it
     */
    @RequestMapping(value = "/getOperationInfo", method = RequestMethod.GET)
    @ResponseBody
    public Response getOperationInfo() {
        LOG.info("Find product by Id");

        Map<String, Object> responseData = new HashMap<>();

        responseData.put("operation", operationOnProduct);
        responseData.put("productId", productId);

        return new Response(ResponseCode.OK, responseData);
    }

    @RequestMapping(value = "/newProduct/saveProduct", method = RequestMethod.POST)
    @ResponseBody
    public Response save(@RequestBody ProductDto product) {
        LOG.info("createProduct. Mapping 'raw' product data: " + product);

        String savedProductNumberValue = this.productService.save(product);
        String newProductNumberValue = getFullProductNumber();
        Map<String, String> responseData = new HashMap<>();

        responseData.put("newProductNumber", newProductNumberValue);
        responseData.put("savedProductNumber", savedProductNumberValue);

        return new Response(ResponseCode.OK, responseData);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response findProductById(@PathVariable Long id) {
        LOG.info("Find product by Id");

        ProductDto product = productService.findById(id);
        String getFullProductName = productService.getFullProductNumber(product.getProductNumber(), product.getIsNew());
        product.setFilePaths(fileService.findFilePaths(getFullProductName));

        return new Response(ResponseCode.OK, product);
    }

    @RequestMapping(value = "/newProduct/deleteProduct/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteProductById(@PathVariable Long id) {
        LOG.info("Delete product by Id");

        String dirNameFromFullProductName = productService.delete(id);
        fileService.deleteDirectory(dirNameFromFullProductName);

        return new Response(ResponseCode.OK, dirNameFromFullProductName);
    }

    @RequestMapping(value = "/newProduct/getNewProductNumber", method = RequestMethod.GET)
    @ResponseBody
    public Response getNumberForNewProduct() {

        LOG.info("Get number for new product");
        String newProductNumberValue = getFullProductNumber();

        return new Response(ResponseCode.OK, newProductNumberValue);
    }

    @RequestMapping(value = "/getFullProductNumber/{productNumber}/{isNew}", method = RequestMethod.GET)
    @ResponseBody
    public Response getNumberForEditableProduct(@PathVariable int productNumber, @PathVariable boolean isNew) {

        LOG.info("Get full number for editable product");
        String number = this.productService.getFullProductNumber(productNumber, isNew);

        return new Response(ResponseCode.OK, number);
    }

    @RequestMapping(value = "/newProduct/allDictionaries", method = RequestMethod.GET)
    @ResponseBody
    public Response findAllDictionaries() {

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
