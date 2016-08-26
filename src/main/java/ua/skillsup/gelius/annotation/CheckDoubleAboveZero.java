package ua.skillsup.gelius.annotation;

import ua.skillsup.gelius.util.validator.CheckDoubleAboveZeroValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckDoubleAboveZeroValidator.class)
@Documented
public @interface CheckDoubleAboveZero {
    String message() default "нарушение ограничения: Double должен быть больше нуля";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
