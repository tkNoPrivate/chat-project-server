package com.example.chat.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.chat.exception.NotFoundException;
import com.example.chat.model.Comment;
import com.example.chat.model.CommentResponse;
import com.example.chat.repository.CommentRepository;
import com.example.chat.repository.mapper.CommentMapper;
import com.example.chat.util.MessageCode;

/**
 * コメントリポジトリ実装
 * 
 * @author tk
 *
 */
@Repository
public class CommentRepositoryImpl implements CommentRepository {

	/** コメントマッパー */
	private final CommentMapper commentMapper;

	/**
	 * コンストラクタ
	 * 
	 * @param commentMapper コメントマッパー
	 */
	public CommentRepositoryImpl(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	@Override
	public CommentResponse select(int commentId) {
		CommentResponse commentResponse = this.commentMapper.select(commentId);
		if (commentResponse == null) {
			throw new NotFoundException(MessageCode.NOT_FOUND);
		}
		return commentResponse;
	}

	@Override
	public int insert(Comment comment) {
		return this.commentMapper.insert(comment);
	}

	@Override
	public int update(Comment comment) {
		return this.commentMapper.update(comment);
	}

	@Override
	public int delete(Comment comment) {
		int resultCount = this.commentMapper.delete(comment);
		if (resultCount == 0) {
			throw new NotFoundException(MessageCode.NOT_FOUND);
		}
		return resultCount;
	}

}
