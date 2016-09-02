package ua.skillsup.gelius.service.impl;

import org.springframework.stereotype.Service;
import ua.skillsup.gelius.service.ValidationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ValidationServiceImpl<T> implements ValidationService<T> {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /*
    Element validation.
    Returns human-readable list of validation errors.
    */
    @Override
    public List<String> validation(T element) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(element);
        List<String> errorList = new ArrayList<>(constraintViolations.size());
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<T> violation : constraintViolations) {
                errorList.add( violation.getMessage() );
            }
        }
        return errorList;
    }

}
