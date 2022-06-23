package com.example.chat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.JoinRoom;
import com.example.chat.repository.JoinRoomRepository;
import com.example.chat.repository.RoomRepository;
import com.example.chat.service.JoinRoomService;
import com.example.chat.util.MessageCode;
import com.example.chat.util.Util;

/**
 * 参加部屋サービス実装
 * 
 * @author tk
 *
 */
@Service
@Transactional
public class JoinRoomServiceImpl implements JoinRoomService {

	/** 参加部屋リポジトリ */
	private final JoinRoomRepository joinRoomRepository;

	/** 部屋リポジトリ */
	private final RoomRepository roomRepository;
	
	/**埋め込み文字_部屋*/
	private final static String ARG_ROOM = "部屋";

	/**
	 * コンストラクタ
	 * 
	 * @param joinRoomRepository 参加部屋リポジトリ
	 * @param roomRepository     部屋リポジトリ
	 */
	public JoinRoomServiceImpl(JoinRoomRepository joinRoomRepository, RoomRepository roomRepository) {
		this.joinRoomRepository = joinRoomRepository;
		this.roomRepository = roomRepository;
	}

	@Override
	public int signup(JoinRoom joinRoom) {
		this.checkExitRoom(joinRoom);

		String strNowDate = Util.getStrNowDate();

		joinRoom.setInsDt(strNowDate);
		joinRoom.setUpdDt(strNowDate);
		return this.joinRoomRepository.insert(joinRoom);
	}

	@Override
	public int deleteByRoomId(JoinRoom joinRoom) {
		return this.joinRoomRepository.deleteByRoomId(joinRoom);
	}

	@Override
	public int delete(JoinRoom joinRoom) {
		this.checkExitRoom(joinRoom);
		return this.joinRoomRepository.delete(joinRoom);
	}
	
	private void checkExitRoom(JoinRoom joinRoom) {
		joinRoom.getRoomIdList().forEach(i -> {
			if (!this.roomRepository.exitById(i)) {
				throw new ConflictException(ARG_ROOM, MessageCode.CONFLICT_DELETE);
			}
		});
	}

}
