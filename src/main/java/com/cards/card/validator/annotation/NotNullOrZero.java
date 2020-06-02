package com.cards.card.validator.annotation;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;
import com.cards.card.validator.NotNullOrZeroValidator;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author suraj.singh
 */
@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = NotNullOrZeroValidator.class)
@Target({TYPE, FIELD, PARAMETER})
public @interface NotNullOrZero {
    String message() default FIELD_REQUIRED;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
