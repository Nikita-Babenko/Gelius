package ua.skillsup.gelius.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.exception.RuntimeNullPointerException;
import ua.skillsup.gelius.model.Data;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class ProductFileUtils {

    private ProductFileUtils() {
    }

    public static String addSuffixToFileName(String fileName) {
        return FilenameUtils.getBaseName(fileName) + Data.FILENAME_SUFFIX + "." + FilenameUtils.getExtension(fileName);
    }


    public static Map<String, MultipartFile> splitFileNameWithAllowedExtensions(List<MultipartFile> files, List<String> allowedFileExtensions) {
        if(files == null || allowedFileExtensions == null){
            throw new RuntimeNullPointerException("File name or file extensions cannot be null");
        }

        Map<String, MultipartFile> fileWithExtensions = new HashMap<>();

        files.forEach(multipartFile -> {

            String fileExtension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

            if (allowedFileExtensions.contains(fileExtension)) {
                fileWithExtensions.put(multipartFile.getOriginalFilename(), multipartFile);
            }
        });

        return files.isEmpty() ? Collections.EMPTY_MAP : fileWithExtensions;
    }


    public static boolean isNotTheSameFile(MultipartFile file,  File serverFile) {
        return serverFile.exists() && serverFile.length() != file.getSize();
    }

    public static String replaceNotAllowedSymbolsInFileName(String fileName) {
        Pattern regexp = Data.ALLOWED_FILENAME_SYMBOLS;

        return regexp.matcher(fileName).replaceAll(Data.FILENAME_REPLACER);
    }
}
