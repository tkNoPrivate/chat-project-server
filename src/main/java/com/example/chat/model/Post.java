package com.example.chat.model;

import lombok.Data;

/**
 * 投稿モデル
 * 
 * @author tk
 *
 */
@Data
public class Post {

	/** 投稿ID */
	private int postId;

	/** 投稿ユーザーID */
	private String postUserId;

	/** 部屋ID */
	private String roomId;

	/** コンテンツ */
	private String contents;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
