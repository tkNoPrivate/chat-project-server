package com.example.chat.repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.PostLike;

/**
 * 投稿いいねリポジトリ
 * 
 * @author tk
 *
 */
public interface PostLikeRepository {

	/**
	 * いいね登録
	 * 
	 * @param postLike 投稿いいねモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int insert(PostLike postLike);

	/**
	 * いいね削除
	 * 
	 * @param postLike 投稿いいねモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int delete(PostLike postLike);
}
