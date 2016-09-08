package ua.skillsup.gelius.service;

import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.service.impl.FileServiceImpl;

import java.util.Map;

public interface FileService {
    void uploadFiles(String fullProductNumber, MultipartFile[] files);
    String addSuffixToFileName(String fileName);
}
