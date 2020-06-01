package com.cards.card.model;

import com.cards.card.validator.annotation.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PersonalDetails {

	@NotBlank
	private String firstname;
	private String middlename;
	private String lastname;
	private String designation;
	private Address address;
	private ContactDetails contactDetails;
}
