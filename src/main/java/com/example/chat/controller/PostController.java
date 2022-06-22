package com.example.chat.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.PostForm;
import com.example.chat.model.CustomUserDetails;
import com.example.chat.model.Post;
import com.example.chat.model.PostResponse;
import com.example.chat.model.ResultCount;
import com.example.chat.service.PostService;

/**
 * 投稿コントローラー
 * 
 * @author tk
 *
 */
@RestController
public class PostController {

	/** 投稿サービス */
	private final PostService postService;

	/**
	 * コンストラクタ
	 * 
	 * @param tk
	 */
	public PostController(PostService postService) {
		this.postService = postService;
	}

	/**
	 * 投稿リスト取得
	 * 
	 * @param roomCd 部屋ID
	 * @return 投稿リスト
	 */
	@GetMapping("/posts/{roomId}")
	public List<PostResponse> getPosts(@AuthenticationPrincipal CustomUserDetails aut, @PathVariable int roomId) {
		return this.postService.getPosts(aut.getUsername(), roomId);

	}

	@GetMapping("/post/search")
	public List<PostResponse> search(@RequestParam(name = "roomId", required = true) String roomId,
			@RequestParam(name = "searchText", required = false) String searchText) {
		return this.postService.search(roomId, searchText);

	}

	/**
	 * 投稿登録
	 * 
	 * @param postForm 投稿フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/post/signup")
	public ResultCount signup(@Validated PostForm postForm) {
		Post post = new Post();
		BeanUtils.copyProperties(postForm, post);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.postService.signup(post));
		return resultCount;

	}

	/**
	 * 投稿更新
	 * 
	 * @param postForm 投稿フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/post/update")
	public ResultCount update(@Validated PostForm postForm) {
		Post post = new Post();
		BeanUtils.copyProperties(postForm, post);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.postService.update(post));
		return resultCount;
	}

	/**
	 * 投稿削除
	 * 
	 * @param postForm 投稿フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/post/delete")
	public ResultCount delete(@Validated PostForm postForm) {
		Post post = new Post();
		BeanUtils.copyProperties(postForm, post);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.postService.delete(post));
		return resultCount;
	}

}
