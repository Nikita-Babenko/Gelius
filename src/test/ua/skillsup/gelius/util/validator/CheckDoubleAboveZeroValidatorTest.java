package ua.skillsup.gelius.util.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CheckDoubleAboveZeroValidatorTest {

    private CheckDoubleAboveZeroValidator checkDoubleAboveZeroValidator = new CheckDoubleAboveZeroValidator();

    @Test
    public void ifPassedDoubleValueIsNull() throws Exception {
        boolean isValid = checkDoubleAboveZeroValidator.isValid(null, new EmptyTestConstraintValidatorContext());

        assertTrue("Is Double passed null", isValid);
    }


    @Test
    public void ifPassedDoubleValueIsNotNull() throws Exception {
        Double value = 0.1;
        boolean isValid = checkDoubleAboveZeroValidator.isValid(value, new EmptyTestConstraintValidatorContext());

        assertTrue("Is Double passed not null", isValid);
    }
}