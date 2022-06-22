package com.example.chat.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.PostLikeForm;
import com.example.chat.model.PostLike;
import com.example.chat.model.ResultCount;
import com.example.chat.service.PostLikeService;

/**
 * 投稿いいねコントローラー
 * 
 * @author tk
 *
 */
@RestController
public class PostLikeController {

	/** 投稿いいねサービス */
	private final PostLikeService postLikeService;

	/**
	 * コンストラクタ
	 * 
	 * @param postLikeService 投稿いいねサービス
	 */
	public PostLikeController(PostLikeService postLikeService) {
		this.postLikeService = postLikeService;
	}

	/**
	 * 投稿いいね登録
	 * 
	 * @param postLikeForm 投稿いいねフォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/postlike/signup")
	public ResultCount signup(PostLikeForm postLikeForm) {
		PostLike postLike = new PostLike();
		BeanUtils.copyProperties(postLikeForm, postLike);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.postLikeService.signup(postLike));
		return resultCount;

	}

	/**
	 * 投稿いいね削除
	 * 
	 * @param postLikeForm 投稿いいねフォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/postlike/delete")
	public ResultCount delete(PostLikeForm postLikeForm) {
		PostLike postLike = new PostLike();
		BeanUtils.copyProperties(postLikeForm, postLike);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.postLikeService.delete(postLike));
		return resultCount;
	}
}
