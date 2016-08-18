package ua.skillsup.gelius.exception;

public class ProductExistsException extends RuntimeException {
    public ProductExistsException(int productNumber) {
        super("Old product (datasheet) width productNumber " + productNumber + " exists");
    }
}
