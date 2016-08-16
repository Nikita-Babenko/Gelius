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
import ua.skillsup.gelius.exception.ParseProductDateException;
import ua.skillsup.gelius.exception.ProductValidationException;
import ua.skillsup.gelius.model.Response;
import ua.skillsup.gelius.model.ResponseCode;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger("ProductController");

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.GET)
    private String openPageNewProduct() {
        LOG.info("Open new product page");
        return "newProduct";
    }

    @RequestMapping(value = "/newProduct/create", method = RequestMethod.POST)
    @ResponseBody
    private Response createProduct(@RequestBody ProductDto product) {
        LOG.info("createProduct controller");
        this.productService.createProduct(product); //возвращаемый productId не сохраняем
        return new Response(ResponseCode.OK);
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response ExceptionHandler(Exception e) {
        LOG.info("ExceptionHandler: " + e);

        if (e instanceof ProductValidationException) {
            List<String> validationErrors = ((ProductValidationException) e).getErrors();
            return new Response(ResponseCode.VALIDATION_ERROR, validationErrors);
        } else if (e instanceof ParseProductDateException) {
            return new Response(ResponseCode.BAD_DATA); //maybe, 415 Unsupported Media Type
        }

        return new Response(ResponseCode.SERVER_ERROR);
    }

}
