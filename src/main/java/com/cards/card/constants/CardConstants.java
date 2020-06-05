package com.cards.card.constants;

public interface CardConstants {

	interface Endpoints {
		String API_V1_ENDPOINT = "/api/v1";
		String CARD_ENPOINT = API_V1_ENDPOINT + "/card";
	}

	interface DeveloperMessage {
		String FIELD_REQUIRED = "FIELD_REQUIRED";
		String PATTREN_MISMATCHED = "PATTREN_MISMATCHED";
		String SIZE_MISMATCHED = "SIZE_MISMATCHED";
		String INCORRECT_TYPE = "INCORRECT_TYPE";

	}
}
