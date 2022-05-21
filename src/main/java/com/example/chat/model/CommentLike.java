package com.example.chat.model;

import lombok.Data;

/**
 * コメントいいねマッパー
 * 
 * @author tk
 *
 */
@Data
public class CommentLike {

	/**コメントID*/
	private int commentId;
	
	/**いいねユーザー*/
	private String userId;
	
	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;
}
