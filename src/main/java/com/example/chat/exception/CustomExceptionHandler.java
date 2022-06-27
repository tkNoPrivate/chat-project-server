package com.example.chat.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.chat.model.ErrorResponse;
import com.example.chat.util.MessageCode;

/**
 * 例外ハンドラー
 * 
 * @author tk
 *
 */
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	/** メッセージソース */
	private MessageSource messageSource;

	/**
	 * コンストラクタ
	 * 
	 * @param messageSource メッセージソース
	 */
	public CustomExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		List<String> messages = new ArrayList<String>();
		List<String> fields = new ArrayList<String>();

		List<ObjectError> objectErrorList = ex.getAllErrors();
		objectErrorList.forEach(s -> {
			fields.add(((FieldError) s).getField());
			String errorMessage = messageSource.getMessage(s, request.getLocale());
			messages.add(errorMessage);
		});

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setFields(fields);
		errorResponse.setMessages(messages);
		return new ResponseEntity<Object>(errorResponse, headers, status);

	}

	/**
	 * NotFoundException
	 * 
	 * @param e       NotFoundException
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<Object> NotFoundException(NotFoundException e, WebRequest request) {
		ErrorResponse message = new ErrorResponse();
		message.setMessages(Arrays.asList(messageSource.getMessage(e.getMessage(), null, request.getLocale())));
		return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);

	}

	/**
	 * ConflictException
	 * 
	 * @param e       ConflictException
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ ConflictException.class })
	public ResponseEntity<Object> ConflictException(ConflictException e, WebRequest request) {
		ErrorResponse message = new ErrorResponse();
		message.setMessages(Arrays.asList(messageSource.getMessage(e.getMessage(),
				e.getArg() != null ? new String[] { e.getArg() } : null, request.getLocale())));
		return new ResponseEntity<Object>(message, HttpStatus.CONFLICT);

	}

	/**
	 * ConfirmPasswordMismatchException
	 * 
	 * @param e       ConfirmPasswordMismatchException
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ ConfirmPasswordMismatchException.class })
	public ResponseEntity<Object> ConfirmPasswordMismatchException(ConfirmPasswordMismatchException e,
			WebRequest request) {
		ErrorResponse message = new ErrorResponse();
		message.setMessages(Arrays.asList(messageSource.getMessage(e.getMessage(), null, request.getLocale())));
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);

	}

	/**
	 * Exception
	 * 
	 * @param e       Exception
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> Exception(Exception e, WebRequest request) {
		ErrorResponse message = new ErrorResponse();
		message.setMessages(
				Arrays.asList(messageSource.getMessage(MessageCode.SYSTEM_ERROR, null, request.getLocale())));
		return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}