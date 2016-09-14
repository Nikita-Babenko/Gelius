package ua.skillsup.gelius.util.validator;


import javax.validation.ConstraintValidatorContext;

public class EmptyTestConstraintValidatorContext implements ConstraintValidatorContext {
    @Override
    public void disableDefaultConstraintViolation() {
        // Do nothing
    }

    @Override
    public String getDefaultConstraintMessageTemplate() {
        // Do nothing
        return null;
    }

    @Override
    public ConstraintViolationBuilder buildConstraintViolationWithTemplate(String messageTemplate) {
        // Do nothing
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> type) {
        // Do nothing
        return null;
    }
}
