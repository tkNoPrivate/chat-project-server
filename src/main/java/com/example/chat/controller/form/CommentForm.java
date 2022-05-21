package com.example.chat.controller.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * コメントフォーム
 * 
 * @author tk
 *
 */
@Data
public class CommentForm {

	/** コメントID */
	private int commentId;

	/** 投稿ID */
	private int postId;

	/** コメントユーザーID */
	private String commentUserId;

	/** コメント */
	@NotBlank
	private String comment;

	/** 反応 */
	private int reaction;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
