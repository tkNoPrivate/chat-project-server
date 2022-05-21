package com.example.chat.service;

import com.example.chat.model.CommentLike;

/**
 * コメントいいねサービス
 * 
 * @author tk
 *
 */
public interface CommentLikeService {

	/**
	 * いいね登録
	 * @param commentLike コメントいいねモデル
	 * @return 更新件数
	 */
	int signup(CommentLike commentLike);
	
	/**
	 * いいね削除
	 * @param commentLike コメントいいねモデル
	 * @return 更新件数
	 */
	int delete(CommentLike commentLike);
}
