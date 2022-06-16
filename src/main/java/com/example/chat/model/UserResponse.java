package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * ユーザーレスポンスモデル
 * 
 * @author tk
 */
@Data
public class UserResponse {

	/** ユーザーID */
	private String userId;

	/** ユーザー名 */
	private String userName;
	
	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

	/** 部屋リスト */
	private List<RoomResponse> rooms;

}
