package com.cards.card.execption;

import com.cards.card.exception.model.ErrorAttribute;
import com.cards.card.exception.model.ErrorCode;

import lombok.Getter;

public class AuthenticationException extends ApiException {

	private static final long serialVersionUID = 4151569448693017560L;

	@Getter
	private ErrorAttribute attribute;

	public AuthenticationException(ErrorCode code) {
		super(code);
	}

	public AuthenticationException(ErrorCode code, ErrorAttribute attribute) {
		super(code);
		this.attribute = attribute;
	}

	public AuthenticationException(ErrorCode code, ErrorAttribute attribute, Throwable cause) {
		super(code, cause);
		this.attribute = attribute;
		this.code = code;
	}

	public AuthenticationException(ErrorCode code, String message) {
		super(code, message);
	}

	public AuthenticationException(ErrorCode code, String message, ErrorAttribute attribute) {
		super(code, message);
		this.attribute = attribute;
	}

	public AuthenticationException(ErrorCode code, String message, ErrorAttribute attribute, Throwable cause) {
		super(code, message, cause);
		this.attribute = attribute;
		this.code = code;
	}

	public AuthenticationException(ErrorCode code, String message, Throwable cause) {
		super(code, message);
	}

	public AuthenticationException(ErrorCode code, Throwable cause) {
		super(code, cause);
	}
}
