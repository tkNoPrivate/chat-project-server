package com.example.chat.model;

import lombok.Data;

/**
 * コメントモデル
 * 
 * @author tk
 *
 */
@Data
public class Comment {

	/** コメントID */
	private int commentId;

	/** 投稿ID */
	private int postId;

	/** コメントユーザーID */
	private String commentUserId;

	/** コメント */
	private String comment;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
