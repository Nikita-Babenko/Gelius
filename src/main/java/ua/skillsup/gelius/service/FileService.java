package ua.skillsup.gelius.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    void uploadFiles(String fullProductNumber, MultipartFile[] files);

    boolean deleteDirectory(String dirName);

    List<String> findFilePaths(String dirName);
}
