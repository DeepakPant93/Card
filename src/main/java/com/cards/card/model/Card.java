package com.cards.card.model;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;

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

	@NotNull(message = FIELD_REQUIRED)
	@Valid
	private PersonalDetails personalDetails;
	private CompanyDetails companyDetails;

}
