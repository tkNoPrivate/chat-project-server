package com.example.chat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.model.CommentLike;
import com.example.chat.repository.CommentLikeRepository;
import com.example.chat.service.CommentLikeService;
import com.example.chat.util.Util;

/**
 * コメントいいねサービス
 * 
 * @author tk
 *
 */
@Service
@Transactional
public class CommentLikeServiceImpl implements CommentLikeService {

	/** コメントいいねリポジトリ */
	private final CommentLikeRepository commentLikeRepository;

	/**
	 * コンストラクタ
	 * 
	 * @param commentLikeRepository コメントいいねリポジトリ
	 */
	public CommentLikeServiceImpl(CommentLikeRepository commentLikeRepository) {
		this.commentLikeRepository = commentLikeRepository;
	}

	@Override
	public int signup(CommentLike commentLike) {
		String strNowDate = Util.getStrNowDate();

		commentLike.setInsDt(strNowDate);
		commentLike.setUpdDt(strNowDate);
		return this.commentLikeRepository.insert(commentLike);
	}

	@Override
	public int delete(CommentLike commentLike) {
		return this.commentLikeRepository.delete(commentLike);
	}

}
