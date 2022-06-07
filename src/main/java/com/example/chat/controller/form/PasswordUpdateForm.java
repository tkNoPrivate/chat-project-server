package com.example.chat.controller.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

import com.example.chat.controller.annotation.CustomSize;
import com.example.chat.controller.annotation.HalfAlphanumeric;
import com.example.chat.controller.annotation.HalfAlphanumericSymbol;

import lombok.Data;

/**
 * パスワード更新フォーム
 * 
 * @author dangshanhaidou
 *
 */
@Data
public class PasswordUpdateForm {
	
	/** ユーザーID */
	@NotBlank
	@CustomSize(min = 1, max = 8)
	@HalfAlphanumeric
	private String userId;
	
	/** 現在のパスワード */
	@NotBlank
	@CustomSize(min = 8, max = 8)
	@HalfAlphanumericSymbol
	private String password;

	/** 新しいパスワード */
	@NotBlank
	@CustomSize(min = 8, max = 8)
	@HalfAlphanumericSymbol
	private String newPassword;
	
	/** 確認用パスワード */
	@NotBlank
	@CustomSize(min = 8, max = 8)
	@HalfAlphanumericSymbol
	private String newConfirmPassword;
	
	/**
	 * 新しいパスワードと確認パスワードの一致チェック
	 * 
	 * @return チェック結果
	 */
	@AssertTrue(message = "{complex.validation.newConfirmPassword}")
	public boolean isNewConfirmPassword() {
		if (newPassword.isEmpty() || newConfirmPassword.isEmpty()) {
			return true;
		}
		return newConfirmPassword.equals(newPassword);
	}

}
