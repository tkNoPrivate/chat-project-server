package com.example.chat.model;

import lombok.Data;

/**
 * 認証情報モデル
 *
 * @author tk
 *
 */
@Data
public class Authentication {

	/** ユーザーID */
	private String userId;

	/** パスワード */
	private String password;

	/** 権限リスト */
	private String role;

}
