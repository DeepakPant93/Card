package com.cards.card.validator.annotation;

import static com.cards.card.constants.CardConstants.DeveloperMessage.INCORRECT_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cards.card.validator.CardStatusValidator;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = CardStatusValidator.class)
@Target({ TYPE, FIELD, PARAMETER })
public @interface CardStatus {

	String message() default INCORRECT_TYPE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
