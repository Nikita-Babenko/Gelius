package ua.skillsup.gelius.exception;

import java.util.List;

public class DeniedFileTypesException extends RuntimeException {

    private List<String> fileNames;

    public DeniedFileTypesException(List<String> fileNames) {
        super("Denied file types of uploaded files: " + fileNames);
        this.fileNames = fileNames;
    }

    public List<String> getFileNames() {
        return this.fileNames;
    }
}
