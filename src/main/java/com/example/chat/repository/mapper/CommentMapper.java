package com.example.chat.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.Comment;

/**
 * コメントマッパー
 * 
 * @author tk
 */
@Mapper
public interface CommentMapper {

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
