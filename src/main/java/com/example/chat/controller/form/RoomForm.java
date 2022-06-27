package com.example.chat.controller.form;

import javax.validation.constraints.NotBlank;

import com.example.chat.controller.annotation.CustomSize;

import lombok.Data;

/**
 * 部屋フォーム
 * 
 * @author tk
 *
 */
@Data
public class RoomForm {

	/** 部屋ID */
	private int roomId;

	/** 部屋名 */
	@NotBlank
	@CustomSize(min = 1, max = 30)
	private String roomName;

	/** 登録ユーザー */
	private String registeredUser;

	/** 更新日時 */
	private String updDt;

}
