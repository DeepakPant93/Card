package com.cards.card.execption;

import com.cards.card.exception.model.ErrorCode;

import lombok.Getter;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -8262500809779681557L;

	@Getter
	protected ErrorCode code;

	public ApiException(ErrorCode code) {
		this.code = code;
	}

	public ApiException(ErrorCode code, String message) {
		super(message);
		this.code = code;
	}

	public ApiException(ErrorCode code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public ApiException(ErrorCode code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

}
