package com.example.chat.controller.form;

import javax.validation.constraints.NotBlank;

import com.example.chat.controller.annotation.CustomSize;

import lombok.Data;

/**
 * 投稿フォーム
 * 
 * @author tk
 *
 */
@Data
public class PostForm {

	/** 投稿ID */
	private int postId;

	/** 投稿ユーザーID */
	private String postUserId;

	/** 部屋ID */
	private String roomId;

	/** コンテンツ */
	@NotBlank
	@CustomSize(min=1,max=100)
	private String contents;

	/** 登録日時 */
	private String insDt;

	/** 更新日時 */
	private String updDt;

}
