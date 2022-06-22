package com.example.chat.repository.impl;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.PostLike;
import com.example.chat.repository.PostLikeRepository;
import com.example.chat.repository.mapper.PostLikeMapper;
import com.example.chat.util.MessageCode;

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
	public int insert(PostLike postLike) {
		try {
			return this.postLikeMapper.insert(postLike);
		} catch (DuplicateKeyException e) {
			throw new ConflictException(MessageCode.CONFLICT_INSERT_LIKE,e);
		}

	}

	@Override
	public int delete(PostLike postLike) {
		int resultCount = this.postLikeMapper.delete(postLike);
		if (resultCount == 0) {
			throw new ConflictException(MessageCode.CONFLICT_DELETE_LIKE);
		}
		return resultCount;
	}

}
