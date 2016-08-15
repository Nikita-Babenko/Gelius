package ua.skillsup.gelius.exception;

import java.util.List;

public class ProductValidationException extends RuntimeException {

    private List<String> errors;

    public ProductValidationException(List<String> errors) {
        super("Invalid Product data: " + errors);
    }
}
