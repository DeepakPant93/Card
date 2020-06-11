package com.cards.card.model.search;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SearchPayload {

	private String address;
	private BigInteger cardId;
	private String cardStatus;
	private String cardType;
	private String city;
	private String companyname;
	private String latitude;
	private String longitude;
	private String thumbnailUrl;
	private String userId;
}
