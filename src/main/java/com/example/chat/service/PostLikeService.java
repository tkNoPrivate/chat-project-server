package com.example.chat.service;

import com.example.chat.model.PostLike;

/**
 * 投稿いいねサービス
 * 
 * @author tk
 *
 */
public interface PostLikeService {

	/**
	 * 投稿いいね登録
	 * 
	 * @param postLike 投稿いいねモデル
	 * @return 更新件数
	 */
	int signup(PostLike postLike);

	/**
	 * 投稿いいね削除
	 * 
	 * @param postLike 投稿いいねモデル
	 * @return 更新件数
	 */
	int delete(PostLike postLike);

}
