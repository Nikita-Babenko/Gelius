package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.gelius.service.DictionaryService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {

    private static final Logger LOG = LoggerFactory.getLogger("DictionaryController");

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    private JSONResponse getAllDictionaries() {
        LOG.info("Get all dictionaries");
        JSONResponse response = new JSONResponse();
        Map<String, List<?>> dictionaries = dictionaryService.getAllDictionaries();
        response.setMessage("OK");
        response.setCode("200");
        response.setResult(dictionaries);
        return response;
    }

    @RequestMapping(path = "/{dictionary}/{operation}", method = RequestMethod.POST)
    @ResponseBody
    private JSONResponse editDictionary(@PathVariable("dictionary") String dictionary,
                                        @PathVariable("operation") String operation, @RequestBody Object object) {

        LOG.info("Edit dictionary {}", dictionary);

        dictionaryService.editDictionary(dictionary, operation, object);

        JSONResponse response = new JSONResponse();
        response.setMessage("OK");
        response.setCode("200");

        return response;
    }

}
