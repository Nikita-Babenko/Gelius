package ua.skillsup.gelius.service.impl;

import org.springframework.stereotype.Service;
import ua.skillsup.gelius.exception.ParseProductDateException;
import ua.skillsup.gelius.model.Data;
import ua.skillsup.gelius.service.ValidationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
        if (constraintViolations.size() != 0) {
            for (ConstraintViolation<T> violation : constraintViolations) {
                errorList.add( violation.getMessage() );
            }
        }
        return errorList;
    }

    /*
    Date parsing.
    If parsing error occurred, throw ParseProductDateException.
    */
    @Override
    public LocalDate parseDate(String dateValue) {
        if (dateValue == null || "".equals(dateValue) ) {
            return null;
        }
        LocalDate date;
        try {
            date = LocalDate.parse(dateValue, Data.DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new ParseProductDateException(dateValue);
        }
        return date;
    }

}
