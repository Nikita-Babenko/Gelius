package ua.skillsup.gelius.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultCotroller {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    private String index() {
        return "index";
    }

}
