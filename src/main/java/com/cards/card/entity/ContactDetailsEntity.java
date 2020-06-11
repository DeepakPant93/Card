package com.cards.card.entity;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ContactDetailsEntity {

	private String email;
	private List<MobileDetailsEntiy> mobileDetails;
	private boolean emailVerified;

}
