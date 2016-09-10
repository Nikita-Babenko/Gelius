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

import java.io.File;
import java.util.ArrayList;
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

        //For debug ******************************************
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            LOG.info(
                fileName + ": " +
                ", size=" + file.getSize() +
                ", content-type=" + file.getContentType()
            );
        }

        /*File size validation was done in context*/

        List<String> filesWithDeniedTypes = getFileNamesWithDeniedTypes(files);
        if (!filesWithDeniedTypes.isEmpty()) {
            throw new DeniedFileTypesException(filesWithDeniedTypes);
        }

        File dir = this.fileDao.createDirectory(fullProductNumber);
        if (dir == null) {
            throw new FileSavingException("Directory (product number " + fullProductNumber + ") was not created");
        }

        boolean isSaved = this.fileDao.saveFiles(dir, files);
        if (!isSaved) {
            throw new FileSavingException("Files (product number " + fullProductNumber + ") was not saved");
        }

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
    public boolean removeDirectory(String directoryPath) {
        return fileDao.removeDirectory(directoryPath);
    }
}
