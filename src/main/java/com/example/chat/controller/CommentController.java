package com.example.chat.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.CommentForm;
import com.example.chat.model.Comment;
import com.example.chat.model.ResultCount;
import com.example.chat.service.CommentService;

@RestController
public class CommentController {

	/** コメントサービス */
	private final CommentService commentService;

	/**
	 * コンストラクタ
	 * 
	 * @param commentService コメントサービス
	 */
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	/**
	 * コメント登録
	 * 
	 * @param commentForm コメントフォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/comment/signup")
	public ResultCount signup(@Validated CommentForm commentForm) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentForm, comment);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.commentService.signup(comment));
		return resultCount;

	}

	/**
	 * コメント更新
	 * 
	 * @param commentForm コメントフォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/comment/update")
	public ResultCount update(@Validated CommentForm commentForm) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentForm, comment);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.commentService.update(comment));
		return resultCount;

	}
	
	/**
	 * コメント削除
	 * 
	 * @param commentForm コメントフォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/comment/delete")
	public ResultCount delete(@Validated CommentForm commentForm) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentForm, comment);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.commentService.delete(comment));
		return resultCount;

	}

}
