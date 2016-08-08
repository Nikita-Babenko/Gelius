package ua.skillsup.gelius.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.gelius.dto.ClientDto;
import ua.skillsup.gelius.services.ClientService;

import java.util.List;

@Controller
@RequestMapping(value = "/clients")
public class ClientsController {
    private static final Logger LOG = LoggerFactory.getLogger("ClientsController");

    @Autowired
    private ClientService clientService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    private JSONResponse getAllClients() {
        List<ClientDto> clients = clientService.getAllClients();
        return new JSONResponse(clients, "products");
    }

    @RequestMapping(value = "/newClient", method = RequestMethod.POST)
    private String openPageNewProduct() {

        return "newClient";
    }
}
