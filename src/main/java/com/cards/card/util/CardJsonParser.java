package com.cards.card.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class CardJsonParser {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public String toJson(Object payload) {
		String jsonString = "";
		try {
			jsonString = MAPPER.writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			log.info("Unable to parse Search payload into JSON string.");
		}
		return jsonString;
	}

	@SuppressWarnings("unchecked")
	public Object fromJson(String jsonString, Class type) {
		try {
			return MAPPER.readValue(jsonString, type);
		} catch (JsonProcessingException e) {
			log.info("Unable to parse Search payload into JSON string.");
		}
		return null;
	}

}
