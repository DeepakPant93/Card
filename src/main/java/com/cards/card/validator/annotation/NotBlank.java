package com.cards.card.validator.annotation;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cards.card.validator.NotBlankValidator;
@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = NotBlankValidator.class)
@Target({ TYPE, FIELD, PARAMETER })
public @interface NotBlank {

	String message()

	default FIELD_REQUIRED;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
