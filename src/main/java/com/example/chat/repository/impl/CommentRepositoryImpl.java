package com.example.chat.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.chat.model.Comment;
import com.example.chat.repository.CommentRepository;
import com.example.chat.repository.mapper.CommentMapper;

/**
 * コメントリポジトリ実装
 * 
 * @author tk
 *
 */
@Repository
public class CommentRepositoryImpl implements CommentRepository{

	/**コメントマッパー*/
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
	public int insert(Comment comment) {	
		return this.commentMapper.insert(comment);
	}

	@Override
	public int update(Comment comment) {
		return this.commentMapper.update(comment);
	}

	@Override
	public int delete(Comment comment) {
		return this.commentMapper.delete(comment);
	}
	
	

}
