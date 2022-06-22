package com.example.chat.repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.JoinRoom;

/**
 * 参加部屋リポジトリ
 * 
 * @author tk
 *
 */
public interface JoinRoomRepository {

	/**
	 * 参加部屋件数取得(最大1件)
	 * 
	 * @param userId ユーザーID
	 * @param roomId 部屋ID
	 * @return 参加部屋件数
	 */
	int selectJoinCount(String userId, int roomId);

	/**
	 * 参加部屋登録
	 * 
	 * @param joinRoom 参加部屋
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int insert(JoinRoom joinRoom);

	/**
	 * 参加部屋削除
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 * @throws ConflictException
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
