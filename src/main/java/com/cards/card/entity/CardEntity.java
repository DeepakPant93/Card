package com.cards.card.entity;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Document;

import com.cards.card.enums.CardStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection = "Card")
public class CardEntity {

	private BigInteger id;
	private PersonalDetailsEntity personalDetails;
	private CompanyDetailsEntity companyDetails;
	private CardStatus status;

}
