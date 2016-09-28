package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.service.FileService;
import ua.skillsup.gelius.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ViewController {

    private static final Logger LOG = LoggerFactory.getLogger("View Controller");

    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/downloadPdf/{version}/{id}", method = RequestMethod.GET)
    public ModelAndView downloadPdf(@PathVariable String version, @PathVariable Long id) {
        LOG.info("Download pdf document for product with id=" + id + " and version=" + version);
        ProductDto product = productService.findById(id);
        String fullProductNumber = productService.getFullProductNumber(product.getProductNumber(), product.getIsNew());

        String productDirectoryPath = Data.DIRECTORY_PATH + fullProductNumber;
        List<String> productFilePaths = fileService.findFilePaths(productDirectoryPath, (String[]) Data.ALLOWED_FILE_EXTENSIONS.toArray(), false);
        List<String> productFileNames = fileService.findFileNames(productDirectoryPath, (String[]) Data.ALLOWED_FILE_EXTENSIONS.toArray(), false);
        product.setFilePaths(productFilePaths);
        product.setFileNames(productFileNames);

        Map<String, Object> model = new HashMap<>();
        model.put("product", product);
        model.put("version", version);

        return new ModelAndView("pdfView", model);
    }

}
