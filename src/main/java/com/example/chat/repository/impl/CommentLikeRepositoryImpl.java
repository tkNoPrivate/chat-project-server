package com.example.chat.repository.impl;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.CommentLike;
import com.example.chat.repository.CommentLikeRepository;
import com.example.chat.repository.mapper.CommentLikeMapper;
import com.example.chat.util.MessageCode;

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
		try {
			return this.commentLikeMapper.insert(commentLike);
		} catch (DuplicateKeyException e) {
			throw new ConflictException(MessageCode.CONFLICT_INSERT_LIKE, e);
		}

	}

	@Override
	public int delete(CommentLike commentLike) {
		int resultCount = this.commentLikeMapper.delete(commentLike);
		if (resultCount == 0) {
			throw new ConflictException(MessageCode.CONFLICT_DELETE_LIKE);
		}
		return this.commentLikeMapper.delete(commentLike);
	}

}
