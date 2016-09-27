package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.gelius.controller.response.Response;
import ua.skillsup.gelius.controller.response.ResponseCode;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.service.ProductRegisterService;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/products")
public class ProductRegisterController {

    private static final Logger LOG = LoggerFactory.getLogger("ProductRegisterController");

    @Autowired
    private ProductRegisterService productRegisterService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String pageRegister() {
        LOG.info("Open register page");
        return "register";
    }

    @RequestMapping(path = "/address", method = RequestMethod.GET)
    @ResponseBody
    public Response getAddress(HttpServletRequest request) throws UnknownHostException {
        String address = InetAddress.getLocalHost().getHostAddress();

        LOG.info("host: " + InetAddress.getLocalHost());
        return new Response(ResponseCode.OK, address);
    }

    @RequestMapping(value = "/allFilterParameters", method = RequestMethod.POST)
    @ResponseBody
    public Response findFilterParameters(@RequestBody ProductRegisterFilter filter) {
        Map parameters = productRegisterService.findAllFilterParameters(filter);

        return new Response(ResponseCode.OK, parameters);
    }


    @RequestMapping(value = "/filtrate", method = RequestMethod.POST)
    @ResponseBody
    public Response findByFilter(@RequestBody ProductRegisterFilter filter) {
        List<ProductRegisterDto> products = productRegisterService.findByFilter(filter);
        LOG.info("Get filtrated products");

        return new Response(ResponseCode.OK, products);
    }
}
