package com.example.chat.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.CommentLikeForm;
import com.example.chat.model.CommentLike;
import com.example.chat.model.ResultCount;
import com.example.chat.service.CommentLikeService;

/**
 * コメントいいねコントローラー
 * 
 * @author tk
 *
 */
@RestController
public class CommentLikeController {

	/** コメントいいねサービス */
	private final CommentLikeService commentLikeService;

	/**
	 * コンストラクタ
	 * 
	 * @param commentLikeService コメントいいねサービス
	 */
	public CommentLikeController(CommentLikeService commentLikeService) {
		this.commentLikeService = commentLikeService;
	}
	
	@PostMapping("/commentlike/signup")
	public ResultCount signup(CommentLikeForm commentLikeForm) {	
		CommentLike commentLike = new CommentLike();
		BeanUtils.copyProperties(commentLikeForm, commentLike);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.commentLikeService.signup(commentLike));
		return resultCount;
		
	}
	
	@PostMapping("/commentlike/delete")
	public ResultCount delete(CommentLikeForm commentLikeForm) {
		CommentLike commentLike = new CommentLike();
		BeanUtils.copyProperties(commentLikeForm, commentLike);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.commentLikeService.delete(commentLike));
		return resultCount;
		
	}
}
