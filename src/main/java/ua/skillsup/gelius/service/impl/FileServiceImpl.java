package ua.skillsup.gelius.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.exception.UnableSaveFileException;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.service.FileService;
import ua.skillsup.gelius.util.ProductFileUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOG = LoggerFactory.getLogger("FileService");

    @Autowired
    private FileDao fileDao;

    @Override
    public void saveOrUpdateFiles(String directoryPath, List<MultipartFile> files, List<String> deletedFiles) {
        boolean isDirectoryExists, isDirectoryCreated, isFilesSaved;

        if(files != null && !files.isEmpty()) printFilesInfo(files);

        File directory = new File(directoryPath);
        Map<String, MultipartFile> filePathWithFiles = ProductFileUtils.splitFileNameWithAllowedExtensions(files, Data.ALLOWED_FILE_EXTENSIONS);

        isDirectoryExists = directory.exists();
        if(isDirectoryExists){
            isFilesSaved = this.fileDao.saveOrUpdateFiles(directoryPath, filePathWithFiles.values(), deletedFiles);
            if (!isFilesSaved) {
                throw new UnableSaveFileException("Files was not saved");
            }
        }
        else {
            isDirectoryCreated = fileDao.createDirectory(directoryPath);
            isFilesSaved = this.fileDao.saveOrUpdateFiles(directoryPath, filePathWithFiles.values(), deletedFiles);
            if (!isDirectoryCreated && !isFilesSaved) {
                throw new UnableSaveFileException("Directory (with path" + directoryPath + ") was not created, and files was not save " + files.size());
            }
        }
    }

    private void printFilesInfo(List<MultipartFile> files){
        files.forEach(multipartFile -> LOG.info(
                                                multipartFile.getOriginalFilename() + ": " +
                                                ", size=" + multipartFile.getSize() +
                                                ", content-type=" + multipartFile.getContentType()));
    }

    @Override
    public boolean deleteDirectory(String directoryPath) {
        return fileDao.deleteDirectory(directoryPath);
    }

    @Override
    public Map<String, String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories) {
        return fileDao.findFilePaths(directoryPath, extensions, isFindInSubdirectories);
    }

}
