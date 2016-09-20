package ua.skillsup.gelius.dao;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface FileDao {

    boolean createDirectory(String directoryPath);

    boolean saveOrUpdateFiles(String directoryPath, Collection<MultipartFile> files, List<String> deletedFiles);

    boolean deleteDirectory(String directoryPath);

    List<String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories);
}
