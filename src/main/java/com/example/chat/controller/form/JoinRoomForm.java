package com.example.chat.controller.form;

import java.util.List;

import lombok.Data;

/**
 * 参加部屋フォーム
 * 
 * @author tk
 *
 */
@Data
public class JoinRoomForm {

	/** ユーザーIDリスト */
	private List<String> userIdList;

	/** 部屋IDリスト */
	private List<Integer> roomIdList;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
