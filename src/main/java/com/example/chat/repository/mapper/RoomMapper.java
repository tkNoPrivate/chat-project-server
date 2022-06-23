package com.example.chat.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.Room;
import com.example.chat.model.RoomResponse;

/**
 * 部屋マッパー
 * 
 * @author tk
 */
@Mapper
public interface RoomMapper {

	/**
	 * 部屋取得
	 * 
	 * @param roomId 部屋ID
	 * @return 部屋レスポンスモデル
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
	 */
	int delete(Room room);

	/**
	 * 部屋数取得
	 * 
	 * @param roomId 部屋ID
	 * @return 部屋数
	 */
	int selectRoomCount(int roomId);

}
