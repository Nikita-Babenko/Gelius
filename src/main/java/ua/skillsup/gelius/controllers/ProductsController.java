package ua.skillsup.gelius.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsFilteringAndSortingDTO;
import ua.skillsup.gelius.services.ProductService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductsController {
    private static final Logger LOG = LoggerFactory.getLogger("ProductsFilter");

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    private String getRegister() {
        return "register";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    private JSONResponse getAllProducts() {
        List<ProductDto> allProducts = productService.getAllProducts();

        return createResponse(allProducts, "products");
    }

    @RequestMapping(value = "/filterParameters/{filterName}", method = RequestMethod.POST)
    @ResponseBody
    private JSONResponse getFilterParameters(@RequestBody ProductsFilteringAndSortingDTO filter, @PathVariable("filterName") String filterName) {
        List parameters = productService.findFilterParameters(filter, filterName);

        return createResponse(parameters, "parameters");
    }


    @RequestMapping(value = "/filtrate", method = RequestMethod.POST)
    @ResponseBody
    private JSONResponse filtrateProducts(@RequestBody ProductsFilteringAndSortingDTO filter) {
        JSONResponse response;
        if (isValidSearchFilter(filter)) {
            List<ProductDto> products = productService.getProductsByFilter(filter);
            response = createResponse(products, "products");
        } else {
            List<ProductDto> allProducts = productService.getAllProducts();
            response = createResponse(allProducts, "products");
        }

        return response;
    }

    private Boolean isValidSearchFilter(ProductsFilteringAndSortingDTO searchFilter) {

        return searchFilter != null && !searchFilter.isEmpty();
    }

    private <T> JSONResponse createResponse(List<T> result, String resultName) {
        JSONResponse response = new JSONResponse();
        if (result.isEmpty() || (result == null)) {
            response.setCode("204");
            response.setMessage("List of " + resultName + " is empty!");
        } else {
            response.setCode("200");
            response.setMessage("OK");
            response.setResult(result);
        }
        return response;
    }
}
