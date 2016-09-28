package ua.skillsup.gelius.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    void saveOrUpdateFiles(String directoryPath, List<MultipartFile> files, List<String> deletedFilePaths);

    boolean deleteDirectory(String directoryPath);

    List<String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories);

    List<String> findFileNames(String directoryPath, String [] extensions, boolean isFindInSubdirectories);

}
