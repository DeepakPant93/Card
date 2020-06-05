package com.cards.card.exception.model;

public enum ErrorCode {

	SYSTEM_EXCEPTION("CS-500"),
	BUSINESS_EXCEPTION("CS-422"),
	BAD_REQUEST("CS-400"),
	UNAUTHORIZED("CS-401"),
	RESOURCE_NOT_FOUND("CS-1001"),
	FIELD_REQUIRED("CS-1002"),
    PATTREN_MISMATCHED("CS-1003"),
    SIZE_MISMATCHED("CS-1003"),
    INCORRECT_TYPE("CS-1004"),
    RESOURCE_NOT_AUTHORIZED("CS-1005");

	private final String code;

	ErrorCode(String code) {
		this.code = code;
	}

	public String code() {
		return this.code;
	}

}
