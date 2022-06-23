package com.example.chat.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.chat.exception.NotFoundException;
import com.example.chat.model.Room;
import com.example.chat.model.RoomResponse;
import com.example.chat.repository.RoomRepository;
import com.example.chat.repository.mapper.RoomMapper;
import com.example.chat.util.MessageCode;

/**
 * 部屋リポジトリ実装
 * 
 * @author tk
 *
 */
@Repository
public class RoomRepositoryImpl implements RoomRepository {

	/** 部屋マッパー */
	private final RoomMapper roomMapper;

	/**
	 * コンストラクタ
	 * 
	 * @param roomMapper 部屋マッパー
	 */
	public RoomRepositoryImpl(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}

	@Override
	public RoomResponse select(int roomId) {
		RoomResponse room = this.roomMapper.select(roomId);
		if (room == null) {
			throw new NotFoundException(MessageCode.NOT_FOUND);
		}
		return room;
	}

	@Override
	public List<RoomResponse> selectListByRegisteredUser(String registeredUser) {
		return this.roomMapper.selectListByRegisteredUser(registeredUser);
	}

	@Override
	public List<RoomResponse> selectNonJoinRooms(String userId) {
		return this.roomMapper.selectNonJoinRooms(userId);
	}

	@Override
	public int insert(Room room) {
		return this.roomMapper.insert(room);
	}

	@Override
	public int update(Room room) {
		return this.roomMapper.update(room);
	}

	@Override
	public int delete(Room room) {
		int resultCount = this.roomMapper.delete(room);
		if (resultCount == 0) {
			throw new NotFoundException(MessageCode.NOT_FOUND);
		}
		return resultCount;
	}

	@Override
	public boolean exitById(int roomId) {
		return this.roomMapper.selectRoomCount(roomId) != 0;
	}

}
