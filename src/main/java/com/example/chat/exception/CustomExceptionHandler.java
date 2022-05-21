package com.example.chat.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.chat.model.Message;
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

		List<String> messageList = new ArrayList<>();

		List<ObjectError> objectErrorList = ex.getAllErrors();
		objectErrorList.forEach(s -> {
			String errorMessage = messageSource.getMessage(s, request.getLocale());
			messageList.add(errorMessage);
		});

		Message message = new Message();
		message.setMessages(messageList);
		return new ResponseEntity<Object>(message, headers, status);

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
		Message message = new Message();
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
		Message message = new Message();
		message.setMessages(Arrays
				.asList(messageSource.getMessage(e.getMessage(), new String[] { e.getKey() }, request.getLocale())));
		return new ResponseEntity<Object>(message, HttpStatus.CONFLICT);

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
		Message message = new Message();
		message.setMessages(
				Arrays.asList(messageSource.getMessage(MessageCode.SYSTEM_ERROR, null, request.getLocale())));
		return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}