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
    private Response saveProduct(@RequestBody ProductDto product) {
        return this.productService.createProduct(product);
    }


    /*private JSONResponse createResponse(long id) {
        JSONResponse response = new JSONResponse();
        if (id == 0) {
            response.setCode("???"); // код - ?
            response.setMessage("Ошибка валидации...");
        } else {
            response.setCode("200");
            response.setMessage("OK");
            response.setResult(id);
        }
        return response;
    }*/

}
