package com.example.chat.repository;

import com.example.chat.model.Comment;

/**
 * コメントリポジトリ
 * 
 * @author tk
 *
 */
public interface CommentRepository {

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
	 */
	int delete(Comment comment);
}
