package com.example.chat.service;

import com.example.chat.model.JoinRoom;

/**
 * 参加部屋サービス
 * 
 * @author tk
 *
 */
public interface JoinRoomService {

	/**
	 * 参加部屋登録
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int signup(JoinRoom joinRoom);

	/**
	 * 参加部屋削除（部屋ID）
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int deleteByRoomId(JoinRoom joinRoom);

	/**
	 * 参加部屋削除
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int delete(JoinRoom joinRoom);
}
