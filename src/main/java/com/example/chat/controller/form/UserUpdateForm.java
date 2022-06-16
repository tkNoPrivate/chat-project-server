package com.example.chat.controller.form;

import javax.validation.constraints.NotBlank;

import com.example.chat.controller.annotation.CustomSize;
import com.example.chat.controller.annotation.HalfAlphanumeric;

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
	
	/** 更新日時 */
	private String updDt;

}
