package ua.skillsup.gelius.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("/register");
    }

}
