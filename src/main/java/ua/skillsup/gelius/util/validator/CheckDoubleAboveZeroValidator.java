package ua.skillsup.gelius.util.validator;

import ua.skillsup.gelius.annotation.CheckDoubleAboveZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDoubleAboveZeroValidator implements ConstraintValidator<CheckDoubleAboveZero, Double> {

    @Override
    public void initialize(CheckDoubleAboveZero constraintAnnotation) {

    }

    @Override
    public boolean isValid(Double object, ConstraintValidatorContext context) {
        if (null == object) {
            return true;
        }
        return object > 0;
    }
}
