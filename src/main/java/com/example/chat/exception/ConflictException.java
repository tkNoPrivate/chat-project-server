package com.example.chat.exception;

public class ConflictException extends Exception {

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
	 * キー取得
	 * 
	 * @return
	 */
	public String getKey() {
		return this.key;
	}

}
