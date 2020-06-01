package com.cards.card.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cards.card.validator.annotation.NotBlank;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (Objects.nonNull(value) && value.strip().length() > 0);
	}
}
