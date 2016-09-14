package ua.skillsup.gelius.util.validator;

import ua.skillsup.gelius.annotation.CheckOldProductNumberExistence;
import ua.skillsup.gelius.model.dto.ProductDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckOldProductNumberExistenceValidator implements ConstraintValidator<CheckOldProductNumberExistence, ProductDto> {

    @Override
    public void initialize(CheckOldProductNumberExistence constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductDto productDto, ConstraintValidatorContext context) {
        return !( !productDto.getIsNew() && productDto.getProductNumber() == null );
    }
}
