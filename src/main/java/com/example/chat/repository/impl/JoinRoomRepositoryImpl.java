package com.example.chat.repository.impl;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.JoinRoom;
import com.example.chat.repository.JoinRoomRepository;
import com.example.chat.repository.mapper.JoinRoomMapper;
import com.example.chat.util.MessageCode;

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

	/** 埋め込み文字_部屋参加情報 */
	private static final String ARG_ROOM_JOIN = "部屋参加情報";

	/** 埋め込み文字_部屋脱退情報 */
	private static final String ARG_ROOM_DROPOUT = "部屋脱退情報";

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
			try {
				resultCount = this.joinRoomMapper.insertCountUser(joinRoom);
			} catch (DuplicateKeyException e) {
				throw new ConflictException(ARG_ROOM_JOIN, MessageCode.CONFLICT_UPDATE, e);
			}

		} else {
			// 部屋IDリストの要素数が多い場合は部屋ID数分テーブルを更新する。
			try {
				resultCount = this.joinRoomMapper.insertCountRoom(joinRoom);
			} catch (DuplicateKeyException e) {
				throw new ConflictException(ARG_ROOM_JOIN, MessageCode.CONFLICT_UPDATE, e);
			}
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
			if (resultCount != userIdListSize) {
				throw new ConflictException(ARG_ROOM_DROPOUT, MessageCode.CONFLICT_UPDATE);
			}
		} else {
			// 部屋IDリストの要素数が多い場合は部屋ID数分テーブルを更新する。
			resultCount = this.joinRoomMapper.deleteCountRoom(joinRoom);
			if (resultCount != roomIdListSize) {
				throw new ConflictException(ARG_ROOM_DROPOUT, MessageCode.CONFLICT_UPDATE);
			}
		}
		return resultCount;
	}

	@Override
	public int deleteByRoomId(JoinRoom joinRoom) {
		return this.joinRoomMapper.deleteByRoomId(joinRoom);
	}

}
