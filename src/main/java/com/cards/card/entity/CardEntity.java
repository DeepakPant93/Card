package com.cards.card.entity;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Document;

import com.cards.card.enums.CardStatusEnum;
import com.cards.card.enums.CardTypeEnum;

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
        private String userId;
	private PersonalDetailsEntity personalDetails;
	private CompanyDetailsEntity companyDetails;
	private CardStatusEnum status;
        private CardTypeEnum cardType;

}
