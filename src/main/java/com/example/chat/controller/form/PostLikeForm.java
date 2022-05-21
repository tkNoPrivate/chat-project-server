package com.example.chat.controller.form;

import lombok.Data;

/**
 * 投稿いいねフォーム
 * 
 * @author tk
 *
 */
@Data
public class PostLikeForm {

	/**投稿ID*/
	private int postId;
	
	/**いいねユーザー*/
	private String userId;
	
	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
