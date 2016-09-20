package ua.skillsup.gelius.dao.impl;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.util.ProductFileUtils;

import java.io.File;
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
    public boolean saveOrUpdateFiles(String directoryPath, Collection<MultipartFile> files, List<String> deletedFiles) {
        LOG.info("save files: " + files);

        Map<String, byte[]> resultMap;
        File directory = new File(directoryPath);
        List<File> allFiles = (List<File>) FileUtils.listFiles(directory, null, false);

        if(deletedFiles == null || deletedFiles.isEmpty()){
            resultMap = ProductFileUtils.getFilesByteMap(new ArrayList<>(files), allFiles);
            allFiles.forEach(File::delete);
            return ProductFileUtils.saveFiles(directoryPath, resultMap);
        } else {
            List<File> resultFiles = new ArrayList<>();
            allFiles.forEach(serverFile -> deletedFiles.forEach(frontendFileName -> {
                if (!serverFile.getName().equals(frontendFileName)) {
                    resultFiles.add(serverFile);
                }
            }));
            resultMap = ProductFileUtils.getFilesByteMap(new ArrayList<>(files), resultFiles);
            allFiles.forEach(File::delete);
            return ProductFileUtils.saveFiles(directoryPath, resultMap);
        }
    }
}
