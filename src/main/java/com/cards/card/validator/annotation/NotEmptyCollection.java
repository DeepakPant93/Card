
package com.cards.card.validator.annotation;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;
import com.cards.card.validator.NotEmptyObjectValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author suraj.singh
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyObjectValidator.class)
public @interface NotEmptyCollection {
    String message() default FIELD_REQUIRED;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
