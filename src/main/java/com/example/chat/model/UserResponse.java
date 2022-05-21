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

	/** 部屋リスト */
	private List<RoomResponse> rooms;

}
