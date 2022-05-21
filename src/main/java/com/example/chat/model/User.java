package com.example.chat.model;

import lombok.Data;

/**
 * 登録モデル
 * 
 * @author tk
 */
@Data
public class User {

	/** ユーザーID */
	private String userId;

	/** ユーザー名 */
	private String userName;

	/** パスワード */
	private String password;

	/** 権限 */
	private String role;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
