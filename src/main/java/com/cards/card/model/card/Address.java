package com.cards.card.model.card;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;
import static com.cards.card.constants.CardConstants.DeveloperMessage.PATTREN_MISMATCHED;
import static com.cards.card.constants.CardConstants.DeveloperMessage.SIZE_MISMATCHED;
import com.cards.card.validator.annotation.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Address {

	@NotBlank
	@Size(min = 2, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z0-9&./-_ ]*", message = PATTREN_MISMATCHED)
	private String addressLine1;

	@NotBlank
	@Size(min = 2, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z0-9&./-_ ]*", message = PATTREN_MISMATCHED)
	private String city;

	@NotBlank
	@Size(min = 2, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z -]*", message = PATTREN_MISMATCHED)
	private String country;

	@NotBlank
	@Size(min = 2, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z -]*", message = PATTREN_MISMATCHED)
	private String district;

	@Size(min = 0, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z0-9&./-_ ]*", message = PATTREN_MISMATCHED)
	private String landmark;

	@NotNull(message = FIELD_REQUIRED)
	private Location location;

	@NotBlank
	private String pin;

	@NotBlank
	@Size(min = 2, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z ]*", message = PATTREN_MISMATCHED)
	private String state;
}
