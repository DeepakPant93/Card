package com.cards.card.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.cards.card.enums.CardTypeEnum;
import com.cards.card.validator.annotation.CardType;

public class CardTypeValidator implements ConstraintValidator<CardType, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (!StringUtils.isEmpty(value)) {
			return List.of(CardTypeEnum.values()).stream().filter(cardType -> cardType.name().equals(value)).findAny()
					.isPresent();
		}
		return true;
	}
}
