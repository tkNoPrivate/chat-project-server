package com.example.chat.service.impl;

import org.springframework.stereotype.Service;

import com.example.chat.model.Comment;
import com.example.chat.repository.CommentRepository;
import com.example.chat.service.CommentService;
import com.example.chat.util.Util;

/**
 * コメントサービス実装
 * 
 * @author tk
 *
 */
@Service
public class CommentServiceImpl implements CommentService{

	/**コメントリポジトリ*/
	private final CommentRepository commentRepository;
	
	/**
	 * コンストラクタ
	 * 
	 * @param commentRepository コメントリポジトリ
	 */
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@Override
	public int signup(Comment comment) {
		String strNowDate = Util.getStrNowDate();

		comment.setInsDt(strNowDate);
		comment.setUpdDt(strNowDate);
		return this.commentRepository.insert(comment);
	}

	@Override
	public int update(Comment comment) {
		comment.setUpdDt(Util.getStrNowDate());
		return this.commentRepository.update(comment);
	}

	@Override
	public int delete(Comment comment) {
		return this.commentRepository.delete(comment);
	}

}
