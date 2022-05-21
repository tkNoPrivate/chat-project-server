package com.example.chat.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.PostLike;

/**
 * 投稿いいねマッパー
 * 
 * @author tk
 *
 */
@Mapper
public interface PostLikeMapper {
	
	/**
	 * いいね登録
	 * 
	 * @param postLike 投稿いいねモデル
	 * @return 更新件数
	 */
	int insert(PostLike postLike);
	
	/**
	 * いいね削除
	 * 
	 * @param postLike 投稿いいねモデル
	 * @return 更新件数
	 */
	int delete(PostLike postLike);
}
