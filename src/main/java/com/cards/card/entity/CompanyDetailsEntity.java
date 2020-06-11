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

	private AddressEntity address;
	private String logoUrl;
	private String name;
	private String tagLine;
	private String website;
}
