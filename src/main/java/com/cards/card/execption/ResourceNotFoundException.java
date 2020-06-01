package com.cards.card.execption;

import static com.cards.card.exception.model.ErrorCode.RESOURCE_NOT_FOUND;

import com.cards.card.exception.model.ErrorAttribute;
import com.cards.card.exception.model.ErrorCode;

public class ResourceNotFoundException extends BusinessException {

	private static final long serialVersionUID = 2876107259032374879L;

	private static final ErrorCode CODE = RESOURCE_NOT_FOUND;

	public ResourceNotFoundException() {
		super(CODE);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(CODE, cause);
	}

	public ResourceNotFoundException(ErrorAttribute attribute) {
		super(CODE, attribute);
	}

	public ResourceNotFoundException(ErrorAttribute attribute, Throwable cause) {
		super(CODE, attribute, cause);
	}

}
