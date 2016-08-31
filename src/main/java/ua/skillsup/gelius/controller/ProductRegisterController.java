package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.service.ProductRegisterService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/products")
public class ProductRegisterController {

    private static final Logger LOG = LoggerFactory.getLogger("ProductRegisterController");

    @Autowired
    private ProductRegisterService productRegisterService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    private String pageRegister() {
        LOG.info("Open register page");
        return "register";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    private JSONResponse findAllProducts() {
        LOG.info("Get all products");
        List<ProductRegisterDto> allProducts = productRegisterService.getAllProducts();
        return createResponse(allProducts, "products");
    }

    @RequestMapping(value = "/allFilterParameters", method = RequestMethod.POST)
    @ResponseBody
    private JSONResponse findFilterParameters(@RequestBody ProductRegisterFilter filter) {
        Map parameters = productRegisterService.findAllFilterParameters(filter);

        return new JSONResponse("200", "OK", parameters);
    }


    @RequestMapping(value = "/filtrate", method = RequestMethod.POST)
    @ResponseBody
    private JSONResponse findByFilter(@RequestBody ProductRegisterFilter filter) {
        List<ProductRegisterDto> products = productRegisterService.findByFilter(filter);
        LOG.info("Get filtrated products");

        return createResponse(products, "products");
    }

    private boolean isValidSearchFilter(ProductRegisterFilter searchFilter) {
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
