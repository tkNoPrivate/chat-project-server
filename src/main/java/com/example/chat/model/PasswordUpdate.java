package com.example.chat.model;

import lombok.Data;

/**
 * パスワード更新モデル
 * 
 * @author dangshanhaidou
 *
 */
@Data
public class PasswordUpdate {

	/** ユーザーID */
	private String userId;

	/** 現在のパスワード */
	private String password;

	/** 新しいパスワード */
	private String newPassword;

	/** 確認用パスワード */
	private String newConfirmPassword;

	/** 更新日付 */
	private String updDt;

}
