package com.cards.card.model.card;

import com.cards.card.validator.annotation.NotBlank;
import com.cards.card.validator.annotation.NotEmptyCollection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.cards.card.constants.CardConstants.DeveloperMessage.PATTREN_MISMATCHED;
import static com.cards.card.constants.CardConstants.DeveloperMessage.SIZE_MISMATCHED;

import java.util.List;

import javax.validation.Valid;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDetails {

	@Valid
	private Address address;

	@NotEmptyCollection
	private List<String> categories;

	private String logoUrl;

	@NotBlank
	@Size(min = 2, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z0-9&./-_ ]*", message = PATTREN_MISMATCHED)
	private String name;

	@Size(min = 0, max = 30, message = SIZE_MISMATCHED)
	@Pattern(regexp = "[a-zA-Z0-9&./-_ ]*", message = PATTREN_MISMATCHED)
	private String tagLine;

	private String thumbnailUrl;

	private String website;
}
