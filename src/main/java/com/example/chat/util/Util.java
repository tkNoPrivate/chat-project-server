package com.example.chat.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 共通処理クラス
 * 
 * @author dangshanhaidou
 *
 */
public class Util {

	/**
	 * インスタンス生成禁止
	 * 
	 */
	private Util() {

	}

	/**
	 * 現在日時取得
	 * 
	 * @return 現在日時（文字列）
	 */
	public static String getStrNowDate() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}

}
