package com.example.chat.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.RoomForm;
import com.example.chat.model.CustomUserDetails;
import com.example.chat.model.ResultCount;
import com.example.chat.model.Room;
import com.example.chat.model.RoomResponse;
import com.example.chat.service.RoomService;

/**
 * 部屋コントローラー
 * 
 * @author tk
 *
 */
@RestController
public class RoomController {

	/** 部屋サービス */
	private final RoomService roomService;

	/**
	 * コンストラクタ
	 * 
	 * @param roomService 部屋サービス
	 */
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

	/**
	 * 部屋取得
	 * 
	 * @param roomId 部屋ID
	 * @return 部屋レスポンスモデル
	 */
	@GetMapping("/room/{roomId}")
	public RoomResponse getRoom(@PathVariable int roomId) {
		return this.roomService.getRoom(roomId);
	}

	/**
	 * 作成部屋リスト取得
	 * 
	 * @param registeredUser 部屋登録ユーザー
	 * @return 部屋レスポンスモデル
	 */
	@GetMapping("/rooms/{registeredUser}")
	public List<RoomResponse> getCreatedRooms(@PathVariable String registeredUser) {
		return this.roomService.getCreatedRooms(registeredUser);
	}

	/**
	 * 未参加部屋取得
	 * 
	 * @param registeredUser 部屋名
	 * @return 部屋レスポンスモデル
	 */
	@GetMapping("/rooms/nonjoin")
	public List<RoomResponse> getNonJoinRooms(@AuthenticationPrincipal CustomUserDetails aut) {
		return this.roomService.getNonJoinRooms(aut.getUsername());
	}

	/**
	 * 部屋登録
	 * 
	 * @param roomForm 部屋フォーム
	 * @param 更新件数モデル
	 */
	@PostMapping("/room/signup")
	public ResultCount signup(@Validated RoomForm roomForm) {
		Room room = new Room();
		BeanUtils.copyProperties(roomForm, room);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.roomService.signup(room));
		return resultCount;
	}

	/**
	 * 部屋更新
	 * 
	 * @param roomForm 部屋フォーム
	 * @param 更新件数モデル
	 */
	@PostMapping("/room/update")
	public ResultCount update(@Validated RoomForm roomForm) {
		Room room = new Room();
		BeanUtils.copyProperties(roomForm, room);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.roomService.update(room));
		return resultCount;
	}

	/**
	 * 部屋削除
	 * 
	 * @param roomForm 部屋フォーム
	 * @param 更新件数モデル
	 */
	@PostMapping("/room/delete")
	public ResultCount delete(@Validated RoomForm roomForm) {
		Room room = new Room();
		BeanUtils.copyProperties(roomForm, room);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.roomService.delete(room));
		return resultCount;
	}
}
