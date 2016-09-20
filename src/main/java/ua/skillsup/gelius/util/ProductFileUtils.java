package ua.skillsup.gelius.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.exception.RuntimeNullPointerException;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public final class ProductFileUtils {

    private ProductFileUtils() {
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

    public static Map<String, byte[]> convertNormalFiles(List<File> files, Map<String, byte[]> mapFiles){
        for (File file : files) {
            try {
                byte bytes[] = FileUtils.readFileToByteArray(file);
                mapFiles.put(file.getName(), bytes);
            } catch (IOException e) {
                return Collections.emptyMap();
            }
        }
        return mapFiles;
    }

    public static Map<String, byte[]> convertMultipartFiles(List<MultipartFile> files, Map<String, byte[]> mapFiles){
        for (MultipartFile multipartFile : files) {
            try {
                byte bytes[] = multipartFile.getBytes();
                mapFiles.put(multipartFile.getOriginalFilename(), bytes);
            } catch (IOException e) {
                return Collections.emptyMap();
            }
        }
        return mapFiles;
    }


    public static Map<String, byte[]> mergeFileMaps(Map<String, byte[]> serverFilesMap, Map<String, byte[]> multipartFilesMap){
        Map<String, byte[]> resultFilesMap = new HashMap<>();
        resultFilesMap.putAll(serverFilesMap);

        multipartFilesMap.forEach((multipartFileName, multipartFileBytes) -> {
            final boolean[] isEquals = {false};
            serverFilesMap.forEach((serverFileName, serverFileBytes) -> {
                if(Arrays.equals(multipartFileBytes, serverFileBytes)){
                    isEquals[0] = true;
                }
            });
            if (!isEquals[0]) resultFilesMap.put(multipartFileName, multipartFileBytes);
        });

        return resultFilesMap;
    }

    public static boolean saveFiles (String directoryPath, Map<String, byte[]> resultMap){
        final boolean[] isFileSaved = {true};
        resultMap.forEach((fileName, bytesFile) -> {

            File newFile = new File(directoryPath + File.separator + fileName);

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile))){
                stream.write(bytesFile);
            } catch (IOException e) {
                isFileSaved[0] = false;
            }
        });
        return isFileSaved[0];
    }

    public static Map<String, byte[]> getFilesByteMap(List<MultipartFile> multipartFiles, List<File> normalFiles){
        Map<String, byte[]> normalFilesMap = new HashMap<>();
        normalFilesMap.putAll(ProductFileUtils.convertNormalFiles(normalFiles, normalFilesMap));

        Map<String, byte[]> multipartFilesMap = new HashMap<>();
        multipartFilesMap.putAll(ProductFileUtils.convertMultipartFiles(multipartFiles, multipartFilesMap));

        return ProductFileUtils.mergeFileMaps(normalFilesMap, multipartFilesMap);
    }
}
