package com.cards.card.execption;

import com.cards.card.exception.model.ErrorCode;


public class SystemException extends ApiException {

    private static final long serialVersionUID = 4151569448693017560L;

    private static final ErrorCode CODE = ErrorCode.SYSTEM_EXCEPTION;

    public SystemException(String message, Throwable cause) {
        super(CODE, message, cause);
    }

    public SystemException(String message) {
        super(CODE, message);
    }
}
