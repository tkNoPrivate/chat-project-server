package com.example.chat.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.chat.model.CommentLike;
import com.example.chat.repository.CommentLikeRepository;
import com.example.chat.repository.mapper.CommentLikeMapper;

/**
 * コメントいいねリポジトリ
 * 
 * @author tk
 *
 */
@Repository
public class CommentLikeRepositoryImpl implements CommentLikeRepository {

	/** コメントいいねマッパー */
	private final CommentLikeMapper commentLikeMapper;
	
	/**
	 * コンストラクタ
	 * 
	 * @param commentLikeMapper コメントいいねマッパー
	 */
	public CommentLikeRepositoryImpl(CommentLikeMapper commentLikeMapper) {
		this.commentLikeMapper = commentLikeMapper;
	}

	@Override
	public int insert(CommentLike commentLike) {
		return this.commentLikeMapper.insert(commentLike);
	}

	@Override
	public int delete(CommentLike commentLike) {
		return this.commentLikeMapper.delete(commentLike);
	}

}
