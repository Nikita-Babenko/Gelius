package ua.skillsup.gelius.exception;

public class NotAllowedFileExtensionsException extends RuntimeException {

    public NotAllowedFileExtensionsException() {
        super();
    }

    public NotAllowedFileExtensionsException(String message) {
        super(message);
    }

    public NotAllowedFileExtensionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllowedFileExtensionsException(Throwable cause) {
        super(cause);
    }

    protected NotAllowedFileExtensionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
