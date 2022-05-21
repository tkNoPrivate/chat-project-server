package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * 参加部屋モデル
 * 
 * @author tk
 *
 */
@Data
public class JoinRoom {
	
	/** ユーザーIDリスト */
	private List<String> userIdList;
	
	/**部屋ID*/
	private List<Integer> roomIdList;
	
	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
