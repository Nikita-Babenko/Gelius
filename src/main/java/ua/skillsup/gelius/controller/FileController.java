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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("images") MultipartFile[] images,
            @RequestParam("deleteFileLinks") String[] deleteFileLinks,
            @RequestParam("deleteImages") String[] deleteImages
    ) {
        LOG.info("uploadFiles():" +
                "\n\tproductNumber= " + fullProductNumber + "," +
                "\n\tfilesToSave count= " + files.length + "," +
                "\n\timagesToSave count= " + images.length + "," +
                "\n\tfileLinksToDelete count= " + deleteFileLinks.length + "," +
                "\n\timagesToDelete count= " + deleteImages.length);

        for (String deleteFileLink : deleteFileLinks) {
            System.out.println("LINK: " + deleteFileLink);
        }
        for (String deleteImage : deleteImages) {
            System.out.println("IMAGE: " + deleteImage);
        }

        String directoryPath = Data.DIRECTORY_PATH + fullProductNumber;
        this.fileService.saveFiles(directoryPath, Arrays.asList(files));

        String directoryPathForImages = directoryPath + File.separator + "images";
        this.fileService.saveFiles(directoryPathForImages, Arrays.asList(images));
        return new Response(ResponseCode.OK);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Response updateFiles(
            @RequestParam("serverFiles") String[] oldFiles,
            @RequestParam("fullProductNumber") String fullProductNumber,
            @RequestParam("newFiles") MultipartFile[] newFiles
    ) throws IOException {
        LOG.info("update Files(): productNumber=" + fullProductNumber + "," +
                ", new Files count=" + newFiles.length +
                ", old server files count=" + oldFiles.length);

        String directoryPath = Data.DIRECTORY_PATH + fullProductNumber;

        List<String> oldFilesList = new ArrayList<>();
        Arrays.asList(oldFiles).forEach(pathToFile -> oldFilesList.add(pathToFile.split(fullProductNumber + "/")[1]));

        this.fileService.updateFiles(directoryPath, Arrays.asList(newFiles), oldFilesList);
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
