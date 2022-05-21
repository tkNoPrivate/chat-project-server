package com.example.chat.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.CommentLike;

/**
 * コメントいいねマッパー
 * 
 * @author tk
 *
 */
@Mapper
public interface CommentLikeMapper {
	
	/**
	 * いいね登録
	 * 
	 * @param commentLike コメントいいねモデル
	 * @return 更新件数
	 */
	int insert(CommentLike commentLike);
	
	/**
	 * いいね削除
	 * 
	 * @param commentLike コメントいいねモデル
	 * @return 更新件数
	 */
	int delete(CommentLike commentLike);

}
