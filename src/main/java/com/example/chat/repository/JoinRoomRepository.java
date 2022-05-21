package com.example.chat.repository;

import com.example.chat.model.JoinRoom;

/**
 * 参加部屋リポジトリ
 * 
 * @author tk
 *
 */
public interface JoinRoomRepository {

	/**
	 * 参加部屋登録
	 * 
	 * @param joinRoom 参加部屋
	 * @return 更新件数
	 */
	int insert(JoinRoom joinRoom);

	/**
	 * 参加部屋削除
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int delete(JoinRoom joinRoom);

	/**
	 * 参加部屋削除（部屋ID）
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int deleteByRoomId(JoinRoom joinRoom);

}
