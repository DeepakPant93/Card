package com.cards.card.execption.handler;

import static com.cards.card.exception.model.ErrorCode.BAD_REQUEST;
import static com.cards.card.exception.model.ErrorCode.BUSINESS_EXCEPTION;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cards.card.exception.model.ApiError;
import com.cards.card.exception.model.ErrorAttribute;
import com.cards.card.exception.model.ErrorCode;
import com.cards.card.exception.model.ErrorDetails;
import com.cards.card.execption.BusinessException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ExceptionHelper {

	private static final String ERROR_KEY_FORMAT = "error.code.";

	private MessageSource messageSource;

	public ApiError apiError(ErrorCode code, Locale locale) {
		return ApiError.builder().code(code.code()).message(getMessage(code, locale)).build();
	}

	public ApiError apiError(BusinessException exception, Locale locale) {
		ErrorDetails errorDetails = ErrorDetails.builder().code(exception.getCode().code())
				.message(getMessage(exception.getCode(), locale)).attribute(exception.getAttribute()).build();

		return ApiError.builder().code(BUSINESS_EXCEPTION.code()).message(getMessage(BUSINESS_EXCEPTION, locale))
				.details(List.of(errorDetails)).build();
	}

	public ApiError apiError(MethodArgumentNotValidException exception, Locale locale) {
		FieldError fieldError = exception.getBindingResult().getFieldError();
		ErrorCode errorCode = getErrorCode(fieldError.getDefaultMessage());

		ErrorDetails errorDetails = ErrorDetails.builder().code(getActualErrorCode(errorCode))
				.message(getMessage(errorCode, locale))
				.attribute(ErrorAttribute.builder().key(fieldError.getField()).value(getValue(fieldError)).build())
				.build();

		return ApiError.builder().code(BAD_REQUEST.code()).message(getMessage(BAD_REQUEST, locale))
				.details(List.of(errorDetails)).build();
	}

	private String getValue(FieldError fieldError) {
		Object value = fieldError.getRejectedValue();
		return Objects.nonNull(value) ? fieldError.getRejectedValue().toString() : null;
	}

	private String getMessage(ErrorCode code, Locale locale) {
		String message = "";
		if (Objects.nonNull(code)) {
			try {
				message = messageSource.getMessage(getMessageKey(code.code()), null, locale);
			} catch (NoSuchMessageException exp) {
				log.error("No Message found for {}.", code.code());
			}
		}
		return message;
	}

	private String getMessageKey(String code) {
		return ERROR_KEY_FORMAT + code;
	}

	private ErrorCode getErrorCode(String code) {
		try {
			return ErrorCode.valueOf(code);
		} catch (Exception e) {
			log.error("No Error code found for {}.", code);
		}
		return null;
	}

	private String getActualErrorCode(ErrorCode code) {
		return Objects.nonNull(code) ? code.code() : "";
	}
}
