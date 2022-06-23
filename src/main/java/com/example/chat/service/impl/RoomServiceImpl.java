package com.example.chat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.Room;
import com.example.chat.model.RoomResponse;
import com.example.chat.repository.RoomRepository;
import com.example.chat.service.RoomService;
import com.example.chat.util.MessageCode;
import com.example.chat.util.Util;

/**
 * 部屋サービス実装
 * 
 * @author rk
 *
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	/** 部屋リポジトリ */
	private final RoomRepository roomRepository;

	/** 埋め込み文字_部屋 */
	private final static String ARG_ROOM = "部屋";

	/**
	 * コンストラクタ
	 * 
	 * @param roomRepository 部屋リポジトリ
	 */
	public RoomServiceImpl(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Override
	public RoomResponse getRoom(int roomId) {
		return this.roomRepository.select(roomId);
	}

	@Override
	public List<RoomResponse> getCreatedRooms(String registeredUser) {
		return this.roomRepository.selectListByRegisteredUser(registeredUser);
	}

	@Override
	public List<RoomResponse> getNonJoinRooms(String userId) {
		return this.roomRepository.selectNonJoinRooms(userId);
	}

	@Override
	public int signup(Room room) {
		String strNowDate = Util.getStrNowDate();

		room.setInsDt(strNowDate);
		room.setUpdDt(strNowDate);
		return this.roomRepository.insert(room);
	}

	@Override
	public int update(Room room) {
		this.checkOptimisticLock(room);
		room.setUpdDt(Util.getStrNowDate());
		return this.roomRepository.update(room);
	}

	@Override
	public int delete(Room room) {
		this.checkOptimisticLock(room);
		return this.roomRepository.delete(room);
	}

	private void checkOptimisticLock(Room room) {
		RoomResponse roomResponse = this.roomRepository.select(room.getRoomId());
		if (!room.getUpdDt().equals(roomResponse.getUpdDt())) {
			throw new ConflictException(ARG_ROOM, MessageCode.CONFLICT_UPDATE);
		}
	}

}
