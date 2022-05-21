package com.example.chat.controller.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

import com.example.chat.controller.annotation.CustomSize;
import com.example.chat.controller.annotation.HalfAlphanumeric;
import com.example.chat.controller.annotation.HalfAlphanumericSymbol;

import lombok.Data;

/**
 * ユーザー更新フォーム
 * 
 * @author tk
 */
@Data
public class UserUpdateForm {

	/** ユーザーID */
	@NotBlank
	@CustomSize(min = 1, max = 8)
	@HalfAlphanumeric
	private String userId;

	/** ユーザー名 */
	@NotBlank
	@CustomSize(min = 1, max = 30)
	private String userName;

	/** 現在のパスワード */
	@CustomSize(min = 8, max = 8)
	@HalfAlphanumericSymbol
	private String currentPassword;
	
	/** 新しいパスワード */
	@CustomSize(min = 8, max = 8)
	@HalfAlphanumericSymbol
	private String newPassword;
	
	
	/**
	 * パスワードと新しいパスワードの入力チェック
	 * 
	 * @return チェック結果
	 */
	@AssertTrue(message = "{complex.validation.newPassword}")
	public boolean isNewPassword() {
		if (currentPassword.isEmpty() || newPassword.isEmpty()) {
			return true;
		}
		
		return !currentPassword.isEmpty() && !newPassword.isEmpty();
	} 

}
