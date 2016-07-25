package ua.skillsup.gelius.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.services.ProductService;

import java.util.List;

@RestController
public class JSONController {
    @Autowired
    ProductService productService;

    @RequestMapping(path = "/register/products", method = RequestMethod.GET)
    @ResponseBody
    List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
