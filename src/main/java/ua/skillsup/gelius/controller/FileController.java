package ua.skillsup.gelius.controller;

import org.apache.commons.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.controller.response.Response;
import ua.skillsup.gelius.controller.response.ResponseCode;
import ua.skillsup.gelius.model.Data;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/files")
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger("FileController");

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    private Response uploadFile2(@RequestParam("productNumber") String fullProductNumber,
                                 @RequestParam("files") MultipartFile[] files) {
        LOG.info("Upload files");

        LOG.info("productNumber=" + fullProductNumber);
        LOG.info("Количество полученных файлов: " + files.length);

        //*** Code in this method will be moved to DAO and service layers:-) ***

        Pattern regexp = Pattern.compile("[^a-zA-Zа-яА-ЯҐґЄєІіЇї0-9_\\+\\.\\(\\)!@\\$=-]");
        List<String> allowedFileExtensions = Arrays.asList("pdf", "png", "jpg", "jpeg", "ai", "cdr" /*, "txt"*/); //txt - for debug

        for (MultipartFile file : files) {

            //File size validation was done in context (bean multipartResolver)

            //Content-type validation:
            //Commented for debug:
            /*String[] fileNameParts = file.getOriginalFilename().split("\\.");
            if (fileNameParts.length == 0) {
                LOG.info("File has not extension");
                return new Response(ResponseCode.VALIDATION_ERROR); //TODO insert filename int list
            }
            String extension = fileNameParts[ fileNameParts.length-1 ];
            LOG.info("Расширение файла=" + extension);
            boolean isFileTypeAllowed = false;
            for (String allowedExtension : allowedFileExtensions) {
                if (allowedExtension.equalsIgnoreCase(extension)) {
                    isFileTypeAllowed = true;
                    break;
                }
            }
            if (!isFileTypeAllowed) {
                LOG.info("This file type not allowed: " + extension);
                return new Response(ResponseCode.VALIDATION_ERROR); //TODO insert filename int list
            }*/

            String fileName = file.getOriginalFilename();
            LOG.info(
                    fileName + ": " +
                            "преобразованное имя=" + regexp.matcher(fileName).replaceAll("_") +
                            ", размер=" + file.getSize() +
                            ", content-type=" + file.getContentType() +
                            "."
            );
        }

        if (files.length == 0) {
            return new Response(ResponseCode.OK);
        }

        String rootPath = System.getProperty("catalina.home");

        File dir = new File(rootPath + File.separator + Data.FILES_DIR + File.separator + fullProductNumber);
        boolean dirCreated = false;
        if (!dir.exists()) {
            dirCreated = dir.mkdirs();
        }
        if (!dirCreated) {
            //TODO logging!
            return new Response(ResponseCode.SERVER_ERROR);
        }
        LOG.info("Dir " + fullProductNumber + " created");

        String newFileName = "";

        for (MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();

                //Replacing not allowed symbols in fileName:
                newFileName = regexp.matcher(file.getOriginalFilename()).replaceAll("_");

                //Save file on server:
                File serverFile = new File(dir.getAbsolutePath() + File.separator + newFileName);
                LOG.info("Сохраняем в " + dir.getAbsolutePath() + File.separator + newFileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

            } catch (IOException e) {
                //TODO logging!
                return new Response(ResponseCode.SERVER_ERROR);
            }
        }
        LOG.info("Files was saved");

        return new Response(ResponseCode.OK);
    }


    @ResponseBody
    @ExceptionHandler(FileUploadBase.FileSizeLimitExceededException.class)
    public Response exceptionHandler(FileUploadBase.FileSizeLimitExceededException e) {
        LOG.info("ExceptionHandler (FileUploadBase.FileSizeLimitExceededException): " + e);
        return new Response(ResponseCode.FILE_SIZE_EXCEEDED);
    }

    /* It will be uncommented after debugging
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception e) {
        LOG.info("ExceptionHandler (Exception): " + e);
        return new Response(ResponseCode.SERVER_ERROR);
    }*/


}
