package com.cards.card.model.card;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;

import com.cards.card.validator.annotation.CardStatus;
import com.cards.card.validator.annotation.CardType;
import com.cards.card.validator.annotation.NotBlank;
import java.math.BigInteger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Card {
       
	private BigInteger id;

	@NotNull(message = FIELD_REQUIRED)
	@Valid
	private PersonalDetails personalDetails;

	@NotNull(message = FIELD_REQUIRED)
	@Valid
	private CompanyDetails companyDetails;

	@NotBlank
	@CardStatus
	private String status;

	@NotBlank
	@CardType
	private String type;

}
