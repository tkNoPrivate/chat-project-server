package com.example.chat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.Comment;
import com.example.chat.model.CommentResponse;
import com.example.chat.repository.CommentRepository;
import com.example.chat.service.CommentService;
import com.example.chat.util.MessageCode;
import com.example.chat.util.Util;

/**
 * コメントサービス実装
 * 
 * @author tk
 *
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	/** コメントリポジトリ */
	private final CommentRepository commentRepository;

	/** 埋め込み文字_コメント */
	private static final String ARG_COMMENT = "コメント";

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
		this.checkOptimisticLock(comment);
		comment.setUpdDt(Util.getStrNowDate());
		return this.commentRepository.update(comment);
	}

	@Override
	public int delete(Comment comment) {
		this.checkOptimisticLock(comment);
		return this.commentRepository.delete(comment);
	}

	private void checkOptimisticLock(Comment comment) {
		CommentResponse commentResponse = this.commentRepository.select(comment.getCommentId());
		if (!comment.getUpdDt().equals(commentResponse.getUpdDt())) {
			throw new ConflictException(ARG_COMMENT, MessageCode.CONFLICT_UPDATE);
		}
	}

}
