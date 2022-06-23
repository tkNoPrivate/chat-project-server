package com.example.chat.repository;

import java.util.List;

import com.example.chat.exception.NotFoundException;
import com.example.chat.model.Post;
import com.example.chat.model.PostResponse;

/**
 * 投稿リポジトリ
 * 
 * @author tk
 */
public interface PostRepository {
	
	/**
	 * 投稿取得
	 * 
	 * @param postId 投稿ID
	 * @return 投稿レスポンスモデル
	 * @throws NotFoundException
	 */
	PostResponse select(int postId);

	/**
	 * 投稿リスト取得
	 * 
	 * @param roomId 部屋ID
	 * @return 投稿リスト
	 */
	List<PostResponse> selectList(int roomId);
	
	/**
	 * 投稿検索結果取得
	 * 
	 * @param roomId 部屋ID
	 * @param searchText 検索文字列
	 * @return 投稿リスト
	 */
	List<PostResponse> selectSearchList(String roomId, String searchText);

	/**
	 * 投稿登録
	 * 
	 * @param post 投稿モデル
	 * @return 更新件数
	 */
	int insert(Post post);

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
	 * @throws NotFoundException
	 */
	int delete(Post post);

}
