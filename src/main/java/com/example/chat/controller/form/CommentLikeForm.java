package com.example.chat.controller.form;

import lombok.Data;

/**
 * コメントいいねフォーム
 * 
 * @author tk
 *
 */
@Data
public class CommentLikeForm {
	
	/**コメントID*/
	private int commentId;
	
	/**いいねユーザー*/
	private String userId;
	
	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
