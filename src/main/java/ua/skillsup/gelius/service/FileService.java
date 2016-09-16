package ua.skillsup.gelius.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    void saveFiles(String directoryPath, MultipartFile[] files);

    boolean deleteDirectory(String directoryPath);

    List<String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories);

}
