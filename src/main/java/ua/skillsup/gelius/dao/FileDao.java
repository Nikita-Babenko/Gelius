package ua.skillsup.gelius.dao;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileDao {

    boolean createDirectory(String dirName);

    boolean saveFiles(String dir, MultipartFile[] files);

    boolean deleteDirectory(String dirName);

    List<String> findFilePaths(String dirName);

}
