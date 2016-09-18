package ua.skillsup.gelius.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    void saveFiles(String directoryPath, List<MultipartFile> files);

    boolean updateFiles(String directoryPath, List<MultipartFile> newFiles, List<String> fileNamesFromFrontend);

    boolean deleteDirectory(String directoryPath);

    List<String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories);

}
