package ua.skillsup.gelius.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.exception.RuntimeNullPointerException;
import ua.skillsup.gelius.exception.UnableSaveFileException;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.service.FileService;
import ua.skillsup.gelius.util.ProductFileUtils;

import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOG = LoggerFactory.getLogger("FileService");

    @Autowired
    private FileDao fileDao;

    @Override
    public void saveFiles(String directoryPath, List<MultipartFile> files) {
        if (directoryPath == null || files == null) {
            throw new RuntimeNullPointerException("Directory path or files may be null");
        }
        else printFilesInfo(files);

        final Map<String, MultipartFile> filePathWithFiles = ProductFileUtils.splitFileNameWithAllowedExtensions(files, Data.ALLOWED_FILE_EXTENSIONS);

        /*if (!(fileNameWithExtensions.size() == files.length)){
            throw new NotAllowedFileExtensionsException("Among the files may be with not allowed extensions. " +
                    "Allowed extensions are " + Data.ALLOWED_FILE_EXTENSIONS);
        }*/

        boolean isDirectoryCreated = this.fileDao.createDirectory(directoryPath);

        if (!isDirectoryCreated) {
            throw new UnableSaveFileException("Directory (with path" + directoryPath + ") was not created");
        }

        boolean isFilesSaved = this.fileDao.saveFiles(directoryPath, filePathWithFiles.values());
        if (!isFilesSaved) {
            throw new UnableSaveFileException("Files was not saved");
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
    public List<String> findFilePaths(String directoryPath, String [] extensions, boolean isFindInSubdirectories) {
        return fileDao.findFilePaths(directoryPath, extensions, isFindInSubdirectories);
    }

    @Override
    public boolean updateFiles(String directoryPath, List<MultipartFile> newFiles, List<String> fileNamesFromFrontend) {
        return this.fileDao.updateFiles(directoryPath, newFiles, fileNamesFromFrontend, null, false);
    }
}
