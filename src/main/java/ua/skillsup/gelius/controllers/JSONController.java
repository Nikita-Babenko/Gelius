package ua.skillsup.gelius.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.skillsup.gelius.services.ProductService;

@Controller
public class JSONController {
    @Autowired
    @Qualifier(value = "productServiceImpl")
    ProductService productService;

    @RequestMapping(path = "/registerdata",method = RequestMethod.GET)
    public String dataRegister(ModelMap model){
        model.addAllAttributes(productService.getAllProducts());

        return new String("register");
    }
}
