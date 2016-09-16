package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.controller.response.Response;
import ua.skillsup.gelius.controller.response.ResponseCode;
import ua.skillsup.gelius.exception.NotAllowedFileExtensionsException;
import ua.skillsup.gelius.exception.UnableSaveFileException;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.service.FileService;

@Controller
@RequestMapping("/files")
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger("FileController");

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Response uploadFiles(
        @RequestParam("productNumber") String fullProductNumber,
        @RequestParam("files") MultipartFile[] files
    ) {
        LOG.info("uploadFiles(): productNumber=" + fullProductNumber + ", files count=" + files.length);

        String directoryPath = Data.DIRECTORY_PATH + fullProductNumber;
        this.fileService.saveFiles(directoryPath, files);
        return new Response(ResponseCode.OK);
    }


    //Exception handling

    @ResponseBody
    @ExceptionHandler(NotAllowedFileExtensionsException.class)
    public Response exceptionHandler(NotAllowedFileExtensionsException e) {
        LOG.info("ExceptionHandler: " + e);
        return new Response(ResponseCode.VALIDATION_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(UnableSaveFileException.class)
    public Response exceptionHandler(UnableSaveFileException e) {
        LOG.info("ExceptionHandler: " + e);
        return new Response(ResponseCode.SERVER_ERROR);
    }

    /* It will be uncommented after debug
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception e) {
        LOG.info("ExceptionHandler (Exception): " + e);
        return new Response(ResponseCode.SERVER_ERROR);
    }*/


}
