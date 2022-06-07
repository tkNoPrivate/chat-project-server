package com.example.chat.exception;

public class ConfirmPasswordMismatchException extends Exception {

	/**
	 * コンストラクタ
	 * 
	 * @param message メッセージ
	 */
	public ConfirmPasswordMismatchException(String message) {
		super(message);
	}

}
