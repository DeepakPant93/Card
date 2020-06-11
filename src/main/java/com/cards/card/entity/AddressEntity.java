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
public class AddressEntity {

	private String addressLine1;
	private String country;
	private String city;
	private String district;
	private String landmark;
	private String pin;
	private String state;
}
