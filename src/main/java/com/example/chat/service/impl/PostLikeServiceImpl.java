package com.example.chat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.model.PostLike;
import com.example.chat.repository.PostLikeRepository;
import com.example.chat.service.PostLikeService;
import com.example.chat.util.Util;

/**
 * 投稿いいねサービス
 * 
 * @author tk
 *
 */
@Service
@Transactional
public class PostLikeServiceImpl implements PostLikeService {

	/** 投稿いいねリポジトリ */
	private final PostLikeRepository postLikeRepository;

	/**
	 * コンストラクタ
	 * 
	 * @param postLikeRepository 投稿いいねリポジトリ
	 */
	public PostLikeServiceImpl(PostLikeRepository postLikeRepository) {
		this.postLikeRepository = postLikeRepository;
	}

	@Override
	public int signup(PostLike postLike) {
		String strNowDate = Util.getStrNowDate();

		postLike.setInsDt(strNowDate);
		postLike.setUpdDt(strNowDate);
		return this.postLikeRepository.insert(postLike);
	}

	@Override
	public int delete(PostLike postLike) {
		return this.postLikeRepository.delete(postLike);
	}

}
