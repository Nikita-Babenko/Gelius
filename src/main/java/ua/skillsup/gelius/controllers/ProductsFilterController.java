package ua.skillsup.gelius.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.dto.ProductDto;
import ua.skillsup.gelius.dto.ProductsSearchFilter;
import ua.skillsup.gelius.services.ProductService;

import java.util.List;


@RestController
public class ProductsFilterController {

    private static final Logger LOG = LoggerFactory.getLogger("ProductsFilter");

    @Autowired
    ProductService productService;

    public
    @RequestMapping(value = "/products/search", method = RequestMethod.GET)
    @ResponseBody
    JSONResponse searchProducts(@RequestBody ProductsSearchFilter searchFilter) {

        LOG.info("searchProducts()");

        JSONResponse response = new JSONResponse();
        if (isValidSearchFilter(searchFilter)) {
            LOG.info(searchFilter.toString());
            List<ProductDto> products = productService.getProductsByFilter(searchFilter);
            if (products.isEmpty()) {
                response.setCode("204");
                response.setMessage("List of products is empty!");
                LOG.info("List of products is empty!");
            } else {
                response.setCode("200");
                response.setMessage("OK");
                response.setResult(products);
                LOG.info("List of products is getting!");
            }
        } else {
            response.setCode("400");
            response.setMessage("Filter is empty!");
            LOG.info("Filter is empty!");
        }

        return response;
    }

    private Boolean isValidSearchFilter(ProductsSearchFilter searchFilter) {

        return searchFilter != null && !searchFilter.isEmpty();
    }
}
