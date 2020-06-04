package com.cards.card.model.card;

import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CompanyDetails {

	private String name;
	private String tagLine;
	private String website;
	private String logo;
	private String thumbnailUrl;
	private String logoImageUrl;

	@Valid
	private Address address;

	@Valid
	private ContactDetails contactDetails;
}
