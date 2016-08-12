package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.ProductsFilteringAndSortingDTO;
import ua.skillsup.gelius.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger("ProductController");

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    private String getRegister() {
        LOG.info("Open register page");
        return "register";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    private JSONResponse getAllProducts() {
        LOG.info("Get all products");
        List<ProductDto> allProducts = productService.getAllProducts();

        return createResponse(allProducts, "products");
    }

    @RequestMapping(value = "/filterParameters/{filterName}", method = RequestMethod.POST)
    @ResponseBody
    private JSONResponse getFilterParameters(@RequestBody ProductsFilteringAndSortingDTO filter, @PathVariable("filterName") String filterName) {
        LOG.info("Get filter params of {}", filterName);
        List parameters = productService.findFilterParameters(filter, filterName);

        return createResponse(parameters, "parameters");
    }


    @RequestMapping(value = "/filtrate", method = RequestMethod.POST)
    @ResponseBody
    private JSONResponse filtrateProducts(@RequestBody ProductsFilteringAndSortingDTO filter) {
        LOG.info("Filtering by filter {}", filter);
        JSONResponse response;
        if (isValidSearchFilter(filter)) {
            List<ProductDto> products = productService.getProductsByFilterAndSorting(filter);
            response = createResponse(products, "products");
        } else {
            List<ProductDto> allProducts = productService.getAllProducts();
            response = createResponse(allProducts, "products");
        }

        return response;
    }

    @RequestMapping(value = "/newProduct", method = RequestMethod.GET)
    private String openPageNewProduct() {
        LOG.info("Open new product page");
        return "newProduct";
    }

    private Boolean isValidSearchFilter(ProductsFilteringAndSortingDTO searchFilter) {

        return searchFilter != null && !searchFilter.isEmpty();
    }

    private <T> JSONResponse createResponse(List<T> result, String resultName) {
        JSONResponse response = new JSONResponse();
        if (result.isEmpty()) {
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
