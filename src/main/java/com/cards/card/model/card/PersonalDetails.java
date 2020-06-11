package com.cards.card.model.card;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;
import static com.cards.card.constants.CardConstants.DeveloperMessage.PATTREN_MISMATCHED;
import static com.cards.card.constants.CardConstants.DeveloperMessage.SIZE_MISMATCHED;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cards.card.validator.annotation.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PersonalDetails {

	@Size(max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z -_]*", message = PATTREN_MISMATCHED)
	private String designation;

	@NotBlank
	@Size(min = 2, max = 20, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
	private String firstname;

	@Size(max = 20, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
	private String lastname;

	@Size(max = 20, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
	private String middlename;

	@Valid
	@NotNull(message = FIELD_REQUIRED)
	private ContactDetails contactDetails;
}
