package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * 投稿情報レスポンスモデル
 * 
 * @author tk
 */
@Data
public class PostResponse {

	/** 投稿ID */
	private int postId;

	/** 投稿ユーザーID */
	private String postUserId;

	/** 投稿ユーザー名 */
	private String postUserName;

	/** 部屋ID */
	private String roomId;

	/** コンテンツ */
	private String contents;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

	/** いいねリスト */
	private List<PostLikeResponse> postLikes;

	/** コメントリスト */
	private List<CommentResponse> comments;

}
