package com.example.chat.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.Comment;
import com.example.chat.model.CommentResponse;

/**
 * コメントマッパー
 * 
 * @author tk
 */
@Mapper
public interface CommentMapper {
	
	/**
	 * コメント取得
	 * 
	 * @param commentId コメントID
	 * @return コメントレスポンスモデル
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
	 */
	int delete(Comment comment);
}
