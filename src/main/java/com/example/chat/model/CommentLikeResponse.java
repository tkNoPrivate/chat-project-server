package com.example.chat.model;

import lombok.Data;

/**
 * コメントいいねモデル
 * 
 * @author tk
 *
 */
@Data
public class CommentLikeResponse {
	
	/**投稿ID*/
	private int commentId;
	
	/**いいねユーザー*/
	private String userId;
	
	/** いいねユーザーネーム */
	private String userName;
	
	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
