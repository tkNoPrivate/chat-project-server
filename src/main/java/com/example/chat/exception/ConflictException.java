package com.example.chat.exception;

/**
 * ConflictException
 * 
 * @author TK
 *
 */
public class ConflictException extends RuntimeException {

	/** 埋め込み文字 */
	private String arg;

	/**
	 * コンストラクタ
	 * 
	 * @param arg     埋め込み文字
	 * @param message メッセージ
	 * @param cause   原因
	 */
	public ConflictException(String arg, String message, Throwable cause) {
		super(message, cause);
		this.arg = arg;
	}

	/**
	 * コンストラクタ
	 * 
	 * @param arg     埋め込み文字
	 * @param message メッセージ
	 */
	public ConflictException(String arg, String message) {
		super(message);
		this.arg = arg;
	}

	/**
	 * コンストラクタ
	 * 
	 * @param message メッセージ
	 * @param cause   原因
	 */
	public ConflictException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param message メッセージ
	 */
	public ConflictException(String message) {
		super(message);
	}

	/**
	 * 埋め込み文字取得
	 * 
	 * @return
	 */
	public String getArg() {
		return this.arg;
	}

}
