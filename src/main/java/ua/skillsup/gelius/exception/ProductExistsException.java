package ua.skillsup.gelius.exception;

public class ProductExistsException extends RuntimeException {
    public ProductExistsException(int productNumber) {
        super("Old product (datasheet) with productNumber " + productNumber + " exists");
    }
}
