package com.cards.card.execption.handler;

import static com.cards.card.exception.model.ErrorCode.SYSTEM_EXCEPTION;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cards.card.exception.model.ApiError;
import com.cards.card.execption.BusinessException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class GlobaExceptionHandler {

	private ExceptionHelper helper;
	private static final String EXCEPTION_MSG_FORMAT = "{} Execption occured while procssing the request. Exception : ";

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleSystemException(Exception exp, WebRequest request) {
		log.error(EXCEPTION_MSG_FORMAT, "System", exp);
		return new ResponseEntity<>(helper.apiError(SYSTEM_EXCEPTION, request.getLocale()), INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiError> handleBusinessException(BusinessException busExp, WebRequest request) {
		log.error(EXCEPTION_MSG_FORMAT, "Business", busExp);
		return new ResponseEntity<>(helper.apiError(busExp, request.getLocale()), UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException valExp,
			WebRequest request) {
		log.error(EXCEPTION_MSG_FORMAT + "{}", "Validation", valExp.getMessage());
		return new ResponseEntity<>(helper.apiError(valExp, request.getLocale()), BAD_REQUEST);
	}
}
