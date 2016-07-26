package ua.skillsup.gelius.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.services.ProductService;

import java.util.Arrays;
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

    @RequestMapping(path = "/register/products/filter/{filterName}", method = RequestMethod.GET)
    @ResponseBody
    List<String> getFilterParameters(@PathVariable("filterName") String filterName) {
        List<String> parameters;

        switch (filterName) {
            case "id":
                parameters = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
                break;
            case "client":
                parameters = Arrays.asList("АВК", "Ласунка", "Петрущенко");
                break;
            case "productsName":
                parameters = null;
                break;
            case "productsType":
                parameters = Arrays.asList("Ящик 4-х клапанный большой", "Ящик 4-х клапанный малый", "Лоток", "Перегородка", "Ящик (дно)", "Вкладыш");
                break;
            case "innerLength":
                parameters = Arrays.asList("385", "410", "400", "350", "385", "340");
                break;
            case "innerWidth":
                parameters = Arrays.asList("252", "300", "222", "272");
                break;
            case "innerHeight":
                parameters = Arrays.asList("180", "145", "140", "130");
                break;
            case "grade":
                parameters = Arrays.asList("Т-21", "Т-21Целл", "П-31", "Т-23Бел", "Т-22ЦЕЛ+ЦЕЛ", "Т-21Бел");
                break;
            case "profile":
                parameters = Arrays.asList("B", "ВЕ");
                break;
            case "colour":
                parameters = Arrays.asList("бур/бур", "бел/бур", "бел/бел");
                break;
            case "print":
                parameters = Arrays.asList("АВК14", "Ласунка", "Луцк");
                break;
            default:
                parameters = null;
        }

        return parameters;
    }
}
