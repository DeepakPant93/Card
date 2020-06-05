package com.cards.card.execption;

import static com.cards.card.exception.model.ErrorCode.RESOURCE_NOT_FOUND;

import com.cards.card.exception.model.ErrorCode;

public class ResourceNotFoundException extends BusinessException {

	private static final long serialVersionUID = 487703573561058809L;

	private static final ErrorCode CODE = RESOURCE_NOT_FOUND;

	public ResourceNotFoundException(String message) {
		super(CODE, message);
	}

}
