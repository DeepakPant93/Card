package com.cards.card.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CompanyDetailsEntity {

	private String name;
	private String tagLine;
	private String website;
	private String logo;
	private String logoImageUrl;
	private AddressEntity address;
	private ContactDetailsEntity contactDetails;
}
