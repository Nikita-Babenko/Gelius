package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.controller.response.Response;
import ua.skillsup.gelius.controller.response.ResponseCode;
import ua.skillsup.gelius.service.DictionaryService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dictionaries")
public class DictionaryController {

    private static final Logger LOG = LoggerFactory.getLogger("DictionaryController");

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Response findAllDictionaries() {
        LOG.info("Get all dictionaries");
        Map<String, List<?>> dictionaries = dictionaryService.findAll();
        return new Response(ResponseCode.OK, dictionaries);
    }

    @RequestMapping(path = "/{dictionary}/{operation}", method = RequestMethod.POST)
    @ResponseBody
    public Response edit(@PathVariable("dictionary") String dictionary,
                             @PathVariable("operation") String operation,
                             @RequestBody Object object) {

        LOG.info("Edit dictionary {}", dictionary);

        dictionaryService.update(dictionary, operation, object);

        return new Response(ResponseCode.OK);
    }

}
