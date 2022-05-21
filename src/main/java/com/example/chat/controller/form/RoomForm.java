package com.example.chat.controller.form;

import javax.validation.constraints.NotBlank;

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
	private String roomName;

	/** 登録ユーザー */
	private String registeredUser;

}