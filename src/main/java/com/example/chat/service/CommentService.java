package com.example.chat.service;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.Comment;

/**
 * コメントサービス
 * 
 * @author tk
 *
 */
public interface CommentService {

	/**
	 * コメント登録
	 * 
	 * @param comment コメントモデル
	 * @return 更新件数
	 */
	int signup(Comment comment);

	/**
	 * コメント更新
	 * 
	 * @param comment コメントモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int update(Comment comment);

	/**
	 * コメント削除
	 * 
	 * @param comment コメントモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int delete(Comment comment);
}
