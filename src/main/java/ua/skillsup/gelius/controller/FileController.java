package ua.skillsup.gelius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import ua.skillsup.gelius.model.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/files")
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger("FileController");

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, String> uploadFile(HttpServletRequest request) {
        LOG.info("Upload files");

        List<MultipartFile> files = ((DefaultMultipartHttpServletRequest) request).getFiles("files");
        String fullProductNumber = request.getParameter("productNumber");
        System.out.println("productNumber=" + fullProductNumber);
        System.out.println("Количество полученных файлов: " + files.size());
        for (MultipartFile file : files) {
            //TODO filesize validation
            //TODO content-type validation (application/pdf, image/png, image/jpeg   +ai +cdr)
            //TODO replace not allowed symbols in fileName to    a-zа-яҐґЄєІіЇї0-9_\+\.\(\)!@\$=-    +триУкрБуквы
            System.out.println(
                file.getOriginalFilename() +
                    ": размер=" + file.getSize() +
                    ", content-type=" + file.getContentType() +
                    "."
            );
        }


        String rootPath = System.getProperty("catalina.home");
        System.out.println(rootPath);

        File dir = new File(rootPath + File.separator + Data.FILES_DIR + File.separator + fullProductNumber);
        if (!dir.exists()) {
            boolean dirCreated = dir.mkdirs();
        }

        for (MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();

                // Create the file on server:
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

            } catch (IOException e) {
                Map<String, String> response = new HashMap<>();
                response.put("code", "ERROR");
                return response;
            }
        }


        Map<String, String> response = new HashMap<>();
        response.put("code", "100500");
        return response;
    }

}
