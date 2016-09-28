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

import java.io.File;
import java.util.*;

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
        Map<String, String> productFilePaths = fileService.findFilePaths(productDirectoryPath, (String[]) Data.ALLOWED_FILE_EXTENSIONS.toArray(), false);
        List<String> filePaths = new ArrayList<>(new TreeSet<>(productFilePaths.keySet()));
        product.setFilePaths(filePaths);
        product.setMapFilePathNames(productFilePaths);

        String productDirectoryImagePaths = productDirectoryPath + File.separator + "images";
        Map<String, String> productImagePaths = fileService.findFilePaths(productDirectoryImagePaths, (String[]) Data.ALLOWED_FILE_EXTENSIONS.toArray(), false);
        List<String> imagePaths = new ArrayList<>(new TreeSet<>(productImagePaths.keySet()));
        product.setFileImagePaths(imagePaths);
        product.setMapImagePathNames(productImagePaths);

        Map<String, Object> model = new HashMap<>();
        model.put("product", product);
        model.put("version", version);

        return new ModelAndView("pdfView", model);
    }

}
