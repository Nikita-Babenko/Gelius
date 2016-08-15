package ua.skillsup.gelius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.skillsup.gelius.dao.ProductDao;

@Controller
public class DefaultCotroller {

    @Autowired
    private ProductDao dao;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    private String index() {
        System.out.println(dao.getAllProducts());
        return "index";
    }

}
