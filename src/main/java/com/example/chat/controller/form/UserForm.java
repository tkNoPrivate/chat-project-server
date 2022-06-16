package com.example.chat.controller.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

import com.example.chat.controller.annotation.CustomSize;
import com.example.chat.controller.annotation.HalfAlphanumeric;
import com.example.chat.controller.annotation.HalfAlphanumericSymbol;

import lombok.Data;

/**
 * 登録フォーム
 * 
 * @author tk
 */
@Data
public class UserForm {

	/** ユーザーID */
	@NotBlank
	@CustomSize(min = 1, max = 8)
	@HalfAlphanumeric
	private String userId;

	/** ユーザー名 */
	@NotBlank
	@CustomSize(min = 1, max = 30)
	private String userName;

	/** パスワード */
	@NotBlank
	@CustomSize(min = 8, max = 8)
	@HalfAlphanumericSymbol
	private String password;

	/** 確認用パスワード */
	@NotBlank
	@CustomSize(min = 8, max = 8)
	@HalfAlphanumericSymbol
	private String confirmPassword;


	/**
	 * パスワードと確認パスワードの一致チェック
	 * 
	 * @return チェック結果
	 */
	@AssertTrue(message = "{complex.validation.confirmpassword}")
	public boolean isConfirmPassword() {
		if (password.isEmpty() || confirmPassword.isEmpty()) {
			return true;
		}
		return confirmPassword.equals(password);
	}

}
