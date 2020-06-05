package com.cards.card.execption;

import static com.cards.card.exception.model.ErrorCode.RESOURCE_NOT_AUTHORIZED;

import com.cards.card.exception.model.ErrorCode;

public class ResourceNotAuthorizedException extends BusinessException {

	private static final long serialVersionUID = 2876107259032374879L;

	private static final ErrorCode CODE = RESOURCE_NOT_AUTHORIZED;

	public ResourceNotAuthorizedException(String message) {
		super(CODE, message);
	}

}