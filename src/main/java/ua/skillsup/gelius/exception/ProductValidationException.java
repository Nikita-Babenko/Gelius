package ua.skillsup.gelius.exception;

import java.util.List;

public class ProductValidationException extends RuntimeException {

    private final List<String> errors;

    public ProductValidationException(List<String> errors) {
        super("Invalid Product data: " + errors);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
