package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * 部屋情報レスポンスモデル
 * 
 * @author tk
 */
@Data
public class RoomResponse {

	/** 部屋Id */
	private int roomId;

	/** 部屋名 */
	private String roomName;

	/** 部屋登録ユーザー */
	private String registeredUser;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

	/** 部屋参加ユーザーリスト */
	private List<User> joinUsers;

}
