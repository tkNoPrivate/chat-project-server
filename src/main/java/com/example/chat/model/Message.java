package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * メッセージモデル
 * 
 * @author tk
 */
@Data
public class Message {

	/** メッセージリスト */
	private List<String> messages;

}
