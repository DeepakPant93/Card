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
public class PersonalDetailsEntity {

	private String firstname;
	private String middlename;
	private String lastname;
	private String designation;
	private AddressEntity address;
	private ContactDetailsEntity contactDetails;
}
