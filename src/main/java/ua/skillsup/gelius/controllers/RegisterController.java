package ua.skillsup.gelius.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsSearchFilter;
import ua.skillsup.gelius.services.ProductService;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(path = "/register/products", method = RequestMethod.GET)
    @ResponseBody
    private List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/register/products/filtrate", method = RequestMethod.POST)
    @ResponseBody
    private ProductsSearchFilter filtrate(@RequestBody ProductsSearchFilter productsSearchFilter) {
        return productsSearchFilter;
    }

    @RequestMapping(path = "/register/products/filterParameters/{filterName}", method = RequestMethod.GET)
    @ResponseBody
    private List getFilterParameters(@PathVariable("filterName") String filterName) {
        List parameters;
        switch (filterName) {
            case "ids":
                parameters = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                break;
            case "clients":
                parameters = Arrays.asList("АВК", "Ласунка", "Петрущенко");
                break;
            case "names":
                parameters = null;
                break;
            case "types":
                parameters = Arrays.asList("Вкладыш", "Лоток", "Перегородка", "Ящик (дно)", "Ящик 4-х клапанный большой", "Ящик 4-х клапанный малый");
                break;
            case "lengths":
                parameters = Arrays.asList(410, 410, 385, 350, 340);
                break;
            case "widths":
                parameters = Arrays.asList(300, 272, 252, 222);
                break;
            case "heights":
                parameters = Arrays.asList(180, 145, 140, 130);
                break;
            case "grades":
                parameters = Arrays.asList("П-31", "Т-21", "Т-21Бел", "Т-21Целл", "Т-22ЦЕЛ+ЦЕЛ", "Т-23Бел");
                break;
            case "profiles":
                parameters = Arrays.asList("B", "ВЕ");
                break;
            case "colours":
                parameters = Arrays.asList("бел/бел", "бел/бур", "бур/бур");
                break;
            case "prints":
                parameters = Arrays.asList("АВК14", "Ласунка", "Луцк");
                break;
            default:
                parameters = null;
        }

        return parameters;
    }
}
