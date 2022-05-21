package com.example.chat.model;

import lombok.Data;

/**
 * 部屋モデル
 * 
 * @author tk
 *
 */
@Data
public class Room {

	/** 部屋ID */
	private int roomId;

	/** 部屋名 */
	private String roomName;

	/** 登録ユーザー */
	private String registeredUser;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
