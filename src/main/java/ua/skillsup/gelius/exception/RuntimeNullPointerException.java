package ua.skillsup.gelius.exception;

public class RuntimeNullPointerException extends RuntimeException{

    public RuntimeNullPointerException() {
        super();
    }

    public RuntimeNullPointerException(String message) {
        super(message);
    }

    public RuntimeNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeNullPointerException(Throwable cause) {
        super(cause);
    }

    protected RuntimeNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
