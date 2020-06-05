package com.cards.card.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.cards.card.enums.CardStatusEnum;
import com.cards.card.validator.annotation.CardStatus;

public class CardStatusValidator implements ConstraintValidator<CardStatus, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (!StringUtils.isEmpty(value)) {
			return List.of(CardStatusEnum.values()).stream().filter(cardStatus -> cardStatus.name().equals(value)).findAny()
					.isPresent();
		}
		return true;
	}
}
