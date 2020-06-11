package com.cards.card.model.card;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import com.cards.card.validator.annotation.NotEmptyCollection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDetails {

	@Email
	private String email;

	@NotEmptyCollection
	@Valid
	private List<MobileDetails> mobileDetails;
}
