package com.cards.card.model.card;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MobileDetails {

	private String code;
	private String number;
	private boolean enableWhatsAppNumber;
	private boolean verified;
}
