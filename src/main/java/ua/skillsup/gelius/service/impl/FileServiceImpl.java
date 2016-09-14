package ua.skillsup.gelius.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.exception.DeniedFileTypesException;
import ua.skillsup.gelius.exception.FileSavingException;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.service.FileService;
import ua.skillsup.gelius.util.FileNameManipulator.PART;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static ua.skillsup.gelius.util.FileNameManipulator.explodeFileName;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOG = LoggerFactory.getLogger("FileService");

    @Autowired
    private FileDao fileDao;

    @Override
    public void uploadFiles(String fullProductNumber, MultipartFile[] files) {
        if (files.length == 0) {
            return;
        }

        printFilesInfo(files);

        List<String> filesWithDeniedTypes = getFileNamesWithDeniedTypes(files);
        if (!filesWithDeniedTypes.isEmpty()) {
            throw new DeniedFileTypesException(filesWithDeniedTypes);
        }

        boolean isCreated = this.fileDao.createDirectory(fullProductNumber);
        System.out.println(isCreated);
        if (!isCreated) {
            throw new FileSavingException("Directory (product number " + fullProductNumber + ") was not created");
        }

        boolean isSaved = this.fileDao.saveFiles(fullProductNumber, files);
        if (!isSaved) {
            throw new FileSavingException("Files (product number " + fullProductNumber + ") was not saved");
        }

    }

    private void printFilesInfo(MultipartFile[] files){
        List<MultipartFile> filesList = Arrays.asList(files);
        filesList.forEach(multipartFile -> LOG.debug(
                                                multipartFile + ": " +
                                                ", size=" + multipartFile.getSize() +
                                                ", content-type=" + multipartFile.getContentType()));
    }

    private List<String> getFileNamesWithDeniedTypes(MultipartFile[] files) {
        LOG.info("getFileNamesWithDeniedTypes()");
        List<String> fileNamesWithDeniedTypes = new ArrayList<>(files.length);

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            Map<PART, String> fileNameParts = explodeFileName(fileName);

            String extension = fileNameParts.get(PART.EXT);
            LOG.info("File extension=" + extension);
            boolean isFileTypeDenied = true;
            for (String allowedExtension : Data.ALLOWED_FILE_EXTENSIONS) {
                if (allowedExtension.equalsIgnoreCase(extension)) {
                    isFileTypeDenied = false;
                    break;
                }
            }
            if (isFileTypeDenied) {
                fileNamesWithDeniedTypes.add(fileName);
            }
        }

        return fileNamesWithDeniedTypes;
    }

    @Override
    public boolean deleteDirectory(String dirName) {
        return fileDao.deleteDirectory(dirName);
    }

    @Override
    public List<String> findFilePaths(String dirName) {
        return fileDao.findFilePaths(dirName);
    }
}
