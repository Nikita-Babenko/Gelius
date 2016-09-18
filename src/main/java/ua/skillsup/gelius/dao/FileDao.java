package ua.skillsup.gelius.dao;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface FileDao {

    boolean createDirectory(String directoryPath);

    boolean saveFiles(String directoryPath, Collection<MultipartFile> files);

    boolean updateFiles(String directoryPath, List<MultipartFile> newFiles, List<String> fileNamesFromFrontend, String [] extensions, boolean isFindInSubdirectories);

    boolean deleteDirectory(String directoryPath);

    List<String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories);
}
