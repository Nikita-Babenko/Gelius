package ua.skillsup.gelius.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void uploadFiles(String fullProductNumber, MultipartFile[] files);
    String addSuffixToFileName(String fileName);
}
