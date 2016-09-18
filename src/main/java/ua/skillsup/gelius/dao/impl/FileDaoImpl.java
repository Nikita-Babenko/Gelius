package ua.skillsup.gelius.dao.impl;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.util.ProductFileUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Repository
public class FileDaoImpl implements FileDao {

    private static final Logger LOG = LoggerFactory.getLogger("FileDao");

    @Override
    public boolean createDirectory(String directoryPath) {
        LOG.info("createDirectory " + directoryPath);

        File dir = new File(directoryPath);

        return dir.exists() || dir.mkdirs();
    }


    @Override
    public boolean deleteDirectory(String directoryPath) {
        LOG.info("removeFiles from " + directoryPath);
        try {
            File directory = new File(directoryPath);
            FileUtils.deleteDirectory(directory);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories) {
        LOG.info("get file paths from directory" + directoryPath);

        File directory = new File(directoryPath);

        List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, isFindInSubdirectories);
        List<String> listFiles = new ArrayList<>();
        files.forEach(file -> listFiles.add(file.getAbsolutePath()));

        return listFiles.isEmpty() ? Collections.emptyList() : listFiles;
    }

    @Override
    public boolean saveFiles(String directoryPath, Collection<MultipartFile> files) {
        LOG.info("save files: " + files);
        boolean isSaved = ProductFileUtils.saveMultipartFiles(directoryPath, files);
        LOG.info("All files were saved");
        return isSaved;
    }

    @Override
    public boolean updateFiles(String directoryPath, List<MultipartFile> newFiles, List<String> fileNamesFromFrontend, String [] extensions, boolean isFindInSubdirectories) {
        File directory = new File(directoryPath);
        List<File> allFiles = (List<File>) FileUtils.listFiles(directory, extensions, isFindInSubdirectories);

        List<File> resultFiles = new ArrayList<>();
        allFiles.forEach(serverFile -> fileNamesFromFrontend.forEach(frontendFileName -> {
            if (serverFile.getName().equals(frontendFileName)) {
                resultFiles.add(serverFile);
            }
        }));

        Map<String, byte[]> normalFilesMap = new HashMap<>();
        normalFilesMap.putAll(ProductFileUtils.convertNormalFiles(resultFiles, normalFilesMap));
        allFiles.forEach(File::delete);

        Map<String, byte[]> multipartFilesMap = new HashMap<>();
        multipartFilesMap.putAll(ProductFileUtils.convertMultipartFiles(newFiles, multipartFilesMap));

        Map<String, byte[]> resultMap = ProductFileUtils.mergeFileMaps(normalFilesMap, multipartFilesMap);

        resultMap.forEach((fileName, bytesFile) -> {

            File newFile = new File(directoryPath + File.separator + fileName);

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile))){
                stream.write(bytesFile);
            } catch (IOException e) {
                throw new RuntimeException("Error to update files");
            }
        });

        LOG.info("All files were updated");
        return true;
    }
}
