package com.cards.card.exception.model;

public enum ErrorCode {

	SYSTEM_EXCEPTION("CS-500"),
	BUSINESS_EXCEPTION("CS-422"),
	BAD_REQUEST("CS-400"),
	RESOURCE_NOT_FOUND("CS-1001"),
	FIELD_REQUIRED("CS-1002");

	private final String code;

	ErrorCode(String code) {
		this.code = code;
	}

	public String code() {
		return this.code;
	}

}
