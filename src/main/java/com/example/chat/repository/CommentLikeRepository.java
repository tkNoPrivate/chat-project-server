package com.example.chat.repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.CommentLike;

/**
 * コメントいいねリポジトリ
 * 
 * @author tk
 *
 */
public interface CommentLikeRepository {

	/**
	 * いいね登録
	 * 
	 * @param commentLike コメントいいねモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int insert(CommentLike commentLike);
	
	/**
	 * いいね削除
	 * 
	 * @param commentLike コメントいいねモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int delete(CommentLike commentLike);
}
