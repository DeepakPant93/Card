package com.cards.card.execption;

import com.cards.card.exception.model.ErrorCode;

public class AuthenticationException extends ApiException {

	private static final long serialVersionUID = -2627475246514946725L;

	public AuthenticationException(ErrorCode code) {
		super(code);
	}

	public AuthenticationException(ErrorCode code, String message) {
		super(code, message);
	}

	public AuthenticationException(ErrorCode code, String message, Throwable cause) {
		super(code, message);
	}

	public AuthenticationException(ErrorCode code, Throwable cause) {
		super(code, cause);
	}
}
