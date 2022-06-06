package com.example.chat.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.JoinRoom;

/**
 * 参加部屋マッパー
 * 
 * @author tk
 *
 */
@Mapper
public interface JoinRoomMapper {

	/**
	 * 参加部屋件数取得(最大1件)
	 * 
	 * @param userId ユーザーID
	 * @param roomId 部屋ID
	 * @return 参加部屋件数
	 */
	int selectJoinCount(String userId, int roomId);

	/**
	 * 参加部屋登録（ユーザー数分）
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int insertCountUser(JoinRoom joinRoom);

	/**
	 * 参加部屋登録（部屋数分）
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int insertCountRoom(JoinRoom joinRoom);

	/**
	 * 参加部屋削除（ユーザー数分）
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int deleteCountUser(JoinRoom joinRoom);

	/**
	 * 参加部屋削除（部屋数分）
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int deleteCountRoom(JoinRoom joinRoom);

	/**
	 * 参加部屋削除（部屋ID）
	 * 
	 * @param joinRoom 参加部屋モデル
	 * @return 更新件数
	 */
	int deleteByRoomId(JoinRoom joinRoom);
}
