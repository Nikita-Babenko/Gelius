package ua.skillsup.gelius.exception;

public class ParseProductDateException extends RuntimeException {
    public ParseProductDateException(String dateValue) {
        super("Invalid date: " + dateValue);
    }
}
