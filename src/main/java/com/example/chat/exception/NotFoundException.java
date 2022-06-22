package com.example.chat.exception;

/**
 * NotFoundException
 * 
 * @author TK
 *
 */
public class NotFoundException extends RuntimeException{

	/**
	 * コンストラクタ
	 * 
	 * @param msg メッセージ
	 */
	public  NotFoundException(String msg) {
		super(msg);
	}
}
