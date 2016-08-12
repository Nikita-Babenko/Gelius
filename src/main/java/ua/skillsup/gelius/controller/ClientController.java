package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.gelius.model.dto.ClientDto;
import ua.skillsup.gelius.service.ClientService;

import java.util.List;

@Controller
@RequestMapping(value = "/clients")
public class ClientController {

    private static final Logger LOG = LoggerFactory.getLogger("ClientController");

    @Autowired
    private ClientService clientService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    private JSONResponse getAllClients() {
        LOG.info("Get all clients");
        List<ClientDto> clients = clientService.getAllClients();
        return new JSONResponse(clients, "products");
    }

    @RequestMapping(value = "/newClient", method = RequestMethod.POST)
    private String openPageNewProduct() {
        LOG.info("Open page for new client");
        return "newClient";
    }
}
