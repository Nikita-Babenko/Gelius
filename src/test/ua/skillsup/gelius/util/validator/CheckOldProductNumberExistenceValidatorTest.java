package ua.skillsup.gelius.util.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import ua.skillsup.gelius.model.dto.ProductDto;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CheckOldProductNumberExistenceValidatorTest {

    private CheckOldProductNumberExistenceValidator existenceValidator = new CheckOldProductNumberExistenceValidator();

    private EmptyTestConstraintValidatorContext context = new EmptyTestConstraintValidatorContext();

    private ProductDto productDto;

    @Before
    public void setUp() throws Exception {
        productDto = new ProductDto();
    }

    @Test
    public void isValidWhenIsNewTrueProductNumberNull() throws Exception {
        productDto.setNew(true);

        boolean isValid = existenceValidator.isValid(productDto, context);

        assertEquals("Is valid? When product number is null and isNew is true", isValid, true);
    }

    @Test
    public void isValidWhenIsNewFalseProductNumberNull() throws Exception {
        productDto.setNew(false);

        boolean isValid = existenceValidator.isValid(productDto, context);

        assertEquals("Is valid? When product number is null and isNew is false", isValid, false);
    }

    @Test
    public void isValidWhenIsNewFalseProductNumberNotNull() throws Exception {
        productDto.setNew(false);
        productDto.setProductNumber(1);

        boolean isValid = existenceValidator.isValid(productDto, context);

        assertEquals("Is valid? When product number is not null and isNew is false", isValid, true);
    }

    @Test
    public void isValidWhenIsNewTrueProductNumberNotNull() throws Exception {
        productDto.setNew(true);
        productDto.setProductNumber(1);

        boolean isValid = existenceValidator.isValid(productDto, context);

        assertEquals("Is valid? When product number is not null and isNew is false", isValid, true);
    }
}