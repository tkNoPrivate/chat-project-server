package com.example.chat.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.chat.model.JoinRoom;
import com.example.chat.repository.JoinRoomRepository;
import com.example.chat.repository.mapper.JoinRoomMapper;

/**
 * 参加部屋リポジトリ実装
 * 
 * @author tk
 *
 */
@Repository
public class JoinRoomRepositoryImpl implements JoinRoomRepository {

	/** 参加部屋マッパー */
	private final JoinRoomMapper joinRoomMapper;

	/**
	 * コンストラクタ
	 * 
	 * @param joinRoomMapper 参加部屋マッパー
	 */
	public JoinRoomRepositoryImpl(JoinRoomMapper joinRoomMapper) {
		this.joinRoomMapper = joinRoomMapper;
	}

	@Override
	public int selectJoinCount(String userId, int roomId) {
		return this.joinRoomMapper.selectJoinCount(userId, roomId);
	}

	@Override
	public int insert(JoinRoom joinRoom) {
		int resultCount;

		int userIdListSize = joinRoom.getUserIdList().size();
		int roomIdListSize = joinRoom.getRoomIdList().size();
		// ユーザーIDリストの要素数が部屋IDリストの要素数より多い場合はユーザーID数分テーブルを更新する。
		// 同じサイズの場合も同じSQL呼び出しで問題ない。
		if (userIdListSize >= roomIdListSize) {
			resultCount = this.joinRoomMapper.insertCountUser(joinRoom);
		} else {
			// 部屋IDリストの要素数が多い場合は部屋ID数分テーブルを更新する。
			resultCount = this.joinRoomMapper.insertCountRoom(joinRoom);
		}
		return resultCount;
	}

	@Override
	public int delete(JoinRoom joinRoom) {
		int resultCount;

		int userIdListSize = joinRoom.getUserIdList().size();
		int roomIdListSize = joinRoom.getRoomIdList().size();
		// ユーザーIDリストの要素数が部屋IDリストの要素数より多い場合はユーザーID数分テーブルを更新する。
		// 同じサイズの場合も同じSQL呼び出しで問題ない。
		if (userIdListSize >= roomIdListSize) {
			resultCount = this.joinRoomMapper.deleteCountUser(joinRoom);
		} else {
			// 部屋IDリストの要素数が多い場合は部屋ID数分テーブルを更新する。
			resultCount = this.joinRoomMapper.deleteCountRoom(joinRoom);
		}
		return resultCount;
	}

	@Override
	public int deleteByRoomId(JoinRoom joinRoom) {
		return this.joinRoomMapper.deleteByRoomId(joinRoom);
	}

}
