package com.example.chat.exception;

public class ConfirmPasswordMismatchException extends RuntimeException {

	/**
	 * コンストラクタ
	 * 
	 * @param message メッセージ
	 */
	public ConfirmPasswordMismatchException(String message) {
		super(message);
	}

}
