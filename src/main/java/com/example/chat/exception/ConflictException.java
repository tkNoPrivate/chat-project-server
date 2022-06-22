package com.example.chat.exception;

/**
 * ConflictException
 * 
 * @author TK
 *
 */
public class ConflictException extends RuntimeException {

	/** キー */
	private String key;

	/**
	 * コンストラクタ
	 * 
	 * @param key     キー
	 * @param message メッセージ
	 * @param cause   原因
	 */
	public ConflictException(String key, String message, Throwable cause) {
		super(message, cause);
		this.key = key;
	}

	/**
	 * コンストラクタ
	 * 
	 * @param key     キー
	 * @param message メッセージ
	 */
	public ConflictException(String key, String message) {
		super(message);
		this.key = key;
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
	 * キー取得
	 * 
	 * @return
	 */
	public String getKey() {
		return this.key;
	}

}
