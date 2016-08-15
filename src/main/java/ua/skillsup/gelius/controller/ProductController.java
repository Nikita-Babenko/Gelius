package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.gelius.model.Response;
import ua.skillsup.gelius.model.ResponseCode;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.service.ProductService;

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
        long productId = this.productService.createProduct(product);
        return new Response(ResponseCode.OK, productId);
    }


    //TODO ExceptionResolver:
    // ParseProductDateException(dateValue) ->  return new Response(ResponseCode.ERROR) ?
    // ProductValidationException(validationErrors) ->  return new ResponseWithList<>(ResponseCode.VALIDATION_ERROR, validationErrors)
    // Exception ->  return new Response(ResponseCode.ERROR)

}
