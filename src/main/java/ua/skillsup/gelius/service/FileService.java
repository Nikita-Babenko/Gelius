package ua.skillsup.gelius.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface FileService {

    void saveOrUpdateFiles(String directoryPath, List<MultipartFile> files, List<String> deletedFilePaths);

    boolean deleteDirectory(String directoryPath);

    Map<String, String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories);

}
