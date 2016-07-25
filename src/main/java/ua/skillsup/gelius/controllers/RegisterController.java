package ua.skillsup.gelius.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.skillsup.gelius.services.ProductService;

@Controller
public class RegisterController {
    @Autowired
    ProductService productService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

}
