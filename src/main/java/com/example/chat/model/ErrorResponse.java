package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * エラーレスポンスモデル
 * 
 * @author tk
 */
@Data
public class ErrorResponse {

	/** フィールドリスト */
	private List<String> Fields;

	/** メッセージリスト */
	private List<String> messages;

}
