package com.example.chat.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.chat.model.Post;
import com.example.chat.model.PostResponse;
import com.example.chat.repository.PostRepository;
import com.example.chat.repository.mapper.PostMapper;

/**
 * 投稿リポジトリ実装
 * 
 * @author tk
 *
 */
@Repository
public class PostRepositoryImpl implements PostRepository {

	/** 投稿マッパー */
	private final PostMapper postMapper;

	/**
	 * コンストラクタ
	 * 
	 * @param postMapper 投稿マッパー
	 */
	public PostRepositoryImpl(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	@Override
	public List<PostResponse> selectList(int roomId) {
		return this.postMapper.selectList(roomId);
	}

	@Override
	public List<PostResponse> selectSearchList(String roomId, String searchText) {
		return this.postMapper.selectSearchList(roomId, searchText);
	}

	@Override
	public int insert(Post post) {
		return this.postMapper.insert(post);
	}

	@Override
	public int update(Post post) {
		return this.postMapper.update(post);
	}

	@Override
	public int delete(Post post) {
		return this.postMapper.delete(post);
	}

}
