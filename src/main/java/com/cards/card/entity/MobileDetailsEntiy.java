package com.cards.card.entity;

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
public class MobileDetailsEntiy {

	private String code;
	private BigInteger number;
	private boolean whatsApp;
	private boolean verified;
}
