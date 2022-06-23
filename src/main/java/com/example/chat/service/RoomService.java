package com.example.chat.service;

import java.util.List;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.Room;
import com.example.chat.model.RoomResponse;

/**
 * 部屋サービス
 * 
 * @author tk
 *
 */
public interface RoomService {

	/**
	 * 部屋取得
	 * 
	 * @param roomId 部屋ID
	 * @return 部屋レスポンスモデル
	 */
	RoomResponse getRoom(int roomId);

	/**
	 * 作成部屋リスト取得
	 * 
	 * @param registeredUser 部屋登録ユーザー
	 * @return 部屋レスポンスモデルリスト
	 */
	List<RoomResponse> getCreatedRooms(String registeredUser);

	/**
	 * 未参加部屋取得
	 * 
	 * @param userId ユーザーID
	 * @return 部屋レスポンスモデルリスト
	 */
	List<RoomResponse> getNonJoinRooms(String userId);

	/**
	 * 部屋登録
	 * 
	 * @param room 部屋モデル
	 * @return 更新件数
	 */
	int signup(Room room);

	/**
	 * 部屋更新
	 * 
	 * @param room 部屋モデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int update(Room room);

	/**
	 * 部屋削除
	 * 
	 * @param room 部屋モデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int delete(Room room);
}
