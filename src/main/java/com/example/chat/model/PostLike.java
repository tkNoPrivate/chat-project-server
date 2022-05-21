package com.example.chat.model;

import lombok.Data;

/**
 * 投稿いいねモデル
 * 
 * @author tk
 *
 */
@Data
public class PostLike {
	
	/**投稿ID*/
	private int postId;
	
	/**いいねユーザー*/
	private String userId;
	
	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;
}
