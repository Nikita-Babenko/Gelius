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
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static ua.skillsup.gelius.util.FileNameManipulator.addSuffixToFileName;

@Repository
public class FileDaoImpl implements FileDao {

    private static final Logger LOG = LoggerFactory.getLogger("FileDao");

    @Override
    public boolean createDirectory(String dirName) {
        LOG.info("createDirectory " + dirName);

        File dir = new File(Data.DIRECTORY_PATH + dirName);

        return dir.exists() || dir.mkdirs();
    }


    @Override
    public boolean deleteDirectory(String dirName) {
        LOG.info("removeFiles from " + dirName);

        File dir = new File(Data.DIRECTORY_PATH + dirName);

        try {
            findFilesFromDirectory(dir)
                    .forEach(File::delete);
            return dir.delete();
        } catch (IOException e) {
            return false;
        }
    }

    private List<File> findFilesFromDirectory(File dirName) throws IOException {
        final List<File> files = new ArrayList<>();

        Files.list(dirName.toPath())
                .forEach(path -> files.add(new File(path.toString())));

        return files;
    }

    @Override
    public List<String> findFilePaths(String dirName) {
        LOG.info("get file paths from " + dirName);

        try {
            List<String> listFiles = new ArrayList<>();
            findFilesFromDirectory(new File(Data.DIRECTORY_PATH + dirName))
                    .forEach(file -> listFiles.add(file.getAbsolutePath()));
            return listFiles;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean saveFiles(String fullProductNumber, MultipartFile[] files) {
        LOG.info("saveFiles()");

        for (MultipartFile file : files) {
            String newFileName = replaceNotAllowedSymbolsInFileName(file.getOriginalFilename());

            File serverFile = new File(Data.DIRECTORY_PATH + fullProductNumber + File.separator + newFileName);

            while (isNotTheSameFile(file, serverFile)) {
                serverFile = new File(Data.DIRECTORY_PATH + fullProductNumber + File.separator + addSuffixToFileName(newFileName));
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
