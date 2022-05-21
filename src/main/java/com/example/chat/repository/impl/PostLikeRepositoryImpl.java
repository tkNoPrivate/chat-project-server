package com.example.chat.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.chat.model.PostLike;
import com.example.chat.repository.PostLikeRepository;
import com.example.chat.repository.mapper.PostLikeMapper;

/**
 * 投稿いいねリポジトリ実装
 * 
 * @author tk
 *
 */
@Repository
public class PostLikeRepositoryImpl implements PostLikeRepository {

	/** 投稿いいねマッパー */
	private final PostLikeMapper postLikeMapper;

	/**
	 * コンストラクタ
	 * 
	 * @param postLikeMapper 投稿いいねマッパー
	 */
	public PostLikeRepositoryImpl(PostLikeMapper postLikeMapper) {
		this.postLikeMapper = postLikeMapper;
	}

	@Override
	public int insert(PostLike postLike){
		return this.postLikeMapper.insert(postLike);

	}

	@Override
	public int delete(PostLike postLike) {
		return this.postLikeMapper.delete(postLike);
	}

}
