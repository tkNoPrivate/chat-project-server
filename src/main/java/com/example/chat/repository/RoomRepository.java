package com.example.chat.repository;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;

import com.example.chat.model.Room;
import com.example.chat.model.RoomResponse;

/**
 * 部屋リポジトリ
 * 
 * @author tk
 *
 */
public interface RoomRepository {

	/**
	 * 部屋取得
	 * 
	 * @param roomId 部屋ID
	 * @return 部屋レスポンスモデル
	 * @throws NotFoundException
	 */
	RoomResponse select(int roomId);

	/**
	 * 部屋リスト取得
	 * 
	 * @param registeredUser 部屋登録ユーザー
	 * @return 部屋レスポンスモデルリスト
	 */
	List<RoomResponse> selectListByRegisteredUser(String registeredUser);

	/**
	 * 未参加部屋リスト取得
	 * 
	 * @param userId ユーザーID
	 * @return 部屋レスポンスモデルリスト
	 */
	List<RoomResponse> selectNonJoinRooms(String userId);

	/**
	 * 部屋登録
	 * 
	 * @param room 部屋モデル
	 * @return 更新件数
	 */
	int insert(Room room);

	/**
	 * 部屋更新
	 * 
	 * @param room 部屋モデル
	 * @return 更新件数
	 */
	int update(Room room);

	/**
	 * 部屋削除
	 * 
	 * @param room 部屋モデル
	 * @return 更新件数
	 * @throws NotFoundException
	 */
	int delete(Room room);

	/**
	 * 部屋存在チェック
	 * 
	 * @param roomId 部屋ID
	 * @return チェック結果
	 */
	boolean exitById(int roomId);
}
