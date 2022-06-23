package com.example.chat.repository;

import com.example.chat.exception.NotFoundException;
import com.example.chat.model.Comment;
import com.example.chat.model.CommentResponse;

/**
 * コメントリポジトリ
 * 
 * @author tk
 *
 */
public interface CommentRepository {
	
	/**
	 * コメント取得
	 * 
	 * @param commentId コメントID
	 * @return コメントレスポンスモデル
	 * @throws NotFoundException
	 */
	CommentResponse select(int commentId);

	/**
	 * コメント登録
	 * 
	 * @param comment コメントモデル
	 * @return 更新件数
	 */
	int insert(Comment comment);

	/**
	 * コメント更新
	 * 
	 * @param comment コメントモデル
	 * @return 更新件数
	 */
	int update(Comment comment);
	
	/**
	 * コメント削除
	 * 
	 * @param comment コメントモデル
	 * @return 更新件数
	 * @throws NotFoundException
	 */
	int delete(Comment comment);
}
