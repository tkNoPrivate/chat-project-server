package com.example.chat.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.chat.model.JoinRoom;
import com.example.chat.repository.JoinRoomRepository;
import com.example.chat.service.JoinRoomService;
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

	/**
	 * コンストラクタ
	 * @param joinRoomRepository 参加部屋リポジトリ
	 */
	public JoinRoomServiceImpl(JoinRoomRepository joinRoomRepository) {
		this.joinRoomRepository = joinRoomRepository;
	}

	@Override
	public int signup(JoinRoom joinRoom) {
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
		return this.joinRoomRepository.delete(joinRoom);
	}

}
