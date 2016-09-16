package ua.skillsup.gelius.exception;

public class UnableSaveFileException extends RuntimeException {

    public UnableSaveFileException() {
        super();
    }

    public UnableSaveFileException(String message) {
        super(message);
    }

    public UnableSaveFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableSaveFileException(Throwable cause) {
        super(cause);
    }

    protected UnableSaveFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
