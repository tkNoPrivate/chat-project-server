package com.example.chat.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.JoinRoomForm;
import com.example.chat.model.JoinRoom;
import com.example.chat.model.ResultCount;
import com.example.chat.service.JoinRoomService;

/**
 * 参加部屋コントローラ
 * 
 * @author tk
 *
 */
@RestController
public class JoinRoomController {

	/** 参加部屋サービス */
	private final JoinRoomService joinRoomService;

	/**
	 * コンストラクタ
	 * 
	 * @param joinRoomService 参加部屋サービス
	 */
	public JoinRoomController(JoinRoomService joinRoomService) {
		this.joinRoomService = joinRoomService;
	}

	/**
	 * 参加部屋登録
	 * 
	 * @param joinRoomForm 参加部屋フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/joinroom/signup")
	public ResultCount signup(JoinRoomForm joinRoomForm) {
		JoinRoom joinRoom = new JoinRoom();
		BeanUtils.copyProperties(joinRoomForm, joinRoom);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.joinRoomService.signup(joinRoom));
		return resultCount;
	}

	/**
	 * 参加部屋削除（部屋ID）
	 * 
	 * @param joinRoomForm 参加部屋フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/joinroom/delete/roomid")
	public ResultCount deleteByRoomId(JoinRoomForm joinRoomForm) {
		JoinRoom joinRoom = new JoinRoom();
		BeanUtils.copyProperties(joinRoomForm, joinRoom);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.joinRoomService.deleteByRoomId(joinRoom));
		return resultCount;
	}

	/**
	 * 参加部屋削除
	 * 
	 * @param joinRoomForm 参加部屋フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/joinroom/delete")
	public ResultCount delete(JoinRoomForm joinRoomForm) {
		JoinRoom joinRoom = new JoinRoom();
		BeanUtils.copyProperties(joinRoomForm, joinRoom);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.joinRoomService.delete(joinRoom));
		return resultCount;
	}

}
