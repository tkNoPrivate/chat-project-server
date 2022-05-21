package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * コメントレスポンスモデル
 * 
 * @author tk
 */
@Data
public class CommentResponse {

	/** コメントID */
	private int commentId;

	/** 投稿ID */
	private int postId;

	/** コメントユーザーID */
	private String commentUserId;

	/** コメントユーザーネーム */
	private String commentUserName;

	/** コメント */
	private String comment;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

	/** コメントいいねリスト */
	private List<CommentLikeResponse> commentLikes;

}
