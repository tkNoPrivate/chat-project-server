package com.example.chat.service;

import java.util.List;

import com.example.chat.model.Post;
import com.example.chat.model.PostResponse;

/**
 * 投稿登録サービス
 * 
 * @author tk
 */
public interface PostService {

	/**
	 * 投稿全件取得
	 * 
	 * @param roomCd 部屋ID
	 * @return 投稿リスト
	 */
	List<PostResponse> getPosts(int roomId);

	/**
	 * 投稿検索
	 * 
	 * @param roomId     部屋ID
	 * @param searchText 検索文字列
	 * @return 投稿リスト
	 */
	List<PostResponse> search(String roomId, String searchText);

	/**
	 * 投稿登録
	 * 
	 * @param post 投稿モデル
	 * @return 更新件数
	 */
	int signup(Post post);

	/**
	 * 投稿更新
	 * 
	 * @param post 投稿モデル
	 * @return 更新件数
	 */
	int update(Post post);

	/**
	 * 投稿削除
	 * 
	 * @param post 投稿モデル
	 * @return 更新件数
	 */
	int delete(Post post);

}