package ua.skillsup.gelius.dao;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileDao {

    File createDirectory(String dirName);

    boolean saveFiles(File dir, MultipartFile[] files);

    boolean deleteDirectory(String dirName);

    List<String> findFilePaths(String dirName);

}
