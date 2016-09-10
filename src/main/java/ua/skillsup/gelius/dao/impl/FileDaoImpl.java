package ua.skillsup.gelius.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.model.Data;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import static ua.skillsup.gelius.util.FileNameManipulator.addSuffixToFileName;

@Repository
public class FileDaoImpl implements FileDao {

    private static final Logger LOG = LoggerFactory.getLogger("FileDao");

    //Throws null, if directory was not created.
    @Override
    public File createDirectory(String dirName) {
        LOG.info("createDirectory()");
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + Data.FILES_DIR + File.separator + dirName);
        boolean dirCreated = true;

        if (!dir.exists()) {
            dirCreated = dir.mkdirs();
        }

        if (!dirCreated) {
            return null;
        }

        return dir;
    }


    @Override
    public boolean removeDirectory(String directoryPath) {
        LOG.info("removeFiles");

        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + Data.FILES_DIR + File.separator + directoryPath);

        return deleteFilesWithDirectory(dir);
    }


    private boolean deleteFilesWithDirectory(File path) {
        if(path.exists()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFilesWithDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
        }
        return (path.delete());
    }

    @Override
    public boolean saveFiles(File dir, MultipartFile[] files) {
        LOG.info("saveFiles()");

        for (MultipartFile file : files) {
            String newFileName = replaceNotAllowedSymbolsInFileName(file.getOriginalFilename());
            String path = dir.getAbsolutePath() + File.separator;

            File serverFile = new File(path + newFileName);
            while (isNotTheSameFile(file, serverFile)) {
                serverFile = new File(path + addSuffixToFileName(newFileName));
            }

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                byte[] bytes = file.getBytes();
                stream.write(bytes);
            } catch (IOException e) {
                LOG.info("Error during file saving: " + newFileName + " (original name: " + file.getOriginalFilename() + ")");
                return false;
            }
        }

        LOG.info("All files were saved");
        return true;
    }

    private boolean isNotTheSameFile(MultipartFile file,  File serverFile) {
        return serverFile.exists() && serverFile.length() != file.getSize();
    }

    private String replaceNotAllowedSymbolsInFileName(String fileName) {
        LOG.info("replaceNotAllowedSymbolsInFileName(): " + fileName);
        Pattern regexp = Data.ALLOWED_FILENAME_SYMBOLS;
        return regexp.matcher(fileName).replaceAll(Data.FILENAME_REPLACER);
    }

}
