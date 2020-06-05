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

	private String userId;
	private BigInteger cardId;
	private String companyname;
	private String cardType;
	private String cardStatus;
	private String thumbnailUrl;
	private String locationName;
	private String longitude;
	private String latitude;
}
