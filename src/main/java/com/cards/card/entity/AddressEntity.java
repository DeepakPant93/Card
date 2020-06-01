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

	private String state;
	private String district;
	private String country;
	private int pin;
	private String landmark;
	private String addressLine1;
	private String addressLine2;

}
