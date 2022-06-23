package com.example.chat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.exception.ConflictException;
import com.example.chat.exception.NotFoundException;
import com.example.chat.model.Post;
import com.example.chat.model.PostResponse;
import com.example.chat.repository.JoinRoomRepository;
import com.example.chat.repository.PostRepository;
import com.example.chat.service.PostService;
import com.example.chat.util.MessageCode;
import com.example.chat.util.Util;

/**
 * 投稿サービス実装
 * 
 * @author tk
 *
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

	/** 投稿リポジトリ */
	private final PostRepository postRepository;

	/** 参加部屋リポジトリ */
	private final JoinRoomRepository joinRoomRepository;

	/** 埋め込み文字_投稿 */
	private static final String ARG_POST = "投稿";

	/**
	 * コンストラクタ
	 * 
	 * @param postRepository 投稿リポジトリ
	 */
	public PostServiceImpl(PostRepository postRepository, JoinRoomRepository joinRoomRepository) {
		this.postRepository = postRepository;
		this.joinRoomRepository = joinRoomRepository;
	}

	@Override
	public List<PostResponse> getPosts(String userId, int roomId) {
		// ログインユーザーが部屋に参加しているかチェックを行う。
		if (this.joinRoomRepository.selectJoinCount(userId, roomId) == 0) {
			throw new NotFoundException(MessageCode.NOT_FOUND);
		}
		return this.postRepository.selectList(roomId);
	}

	@Override
	public List<PostResponse> search(String roomId, String searchText) {
		return this.postRepository.selectSearchList(roomId, searchText);
	}

	@Override
	public int signup(Post post) {
		String strNowDate = Util.getStrNowDate();

		post.setInsDt(strNowDate);
		post.setUpdDt(strNowDate);

		return this.postRepository.insert(post);

	}

	@Override
	public int update(Post post) {
		this.checkOptimisticLock(post);
		post.setUpdDt(Util.getStrNowDate());
		return this.postRepository.update(post);
	}

	@Override
	public int delete(Post post) {
		this.checkOptimisticLock(post);
		return this.postRepository.delete(post);
	}

	private void checkOptimisticLock(Post post) {
		PostResponse postResponse = this.postRepository.select(post.getPostId());
		if (!post.getUpdDt().equals(postResponse.getUpdDt())) {
			throw new ConflictException(ARG_POST, MessageCode.CONFLICT_UPDATE);
		}
	}

}
