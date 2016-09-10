package ua.skillsup.gelius.dao;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileDao {

    File createDirectory(String dirName);

    boolean saveFiles(File dir, MultipartFile[] files);

    boolean removeDirectory(String directoryPath);

}
