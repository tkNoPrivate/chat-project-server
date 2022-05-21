package com.example.chat.controller;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.UserForm;
import com.example.chat.exception.ConflictException;
import com.example.chat.model.CustomUserDetails;
import com.example.chat.model.ResultCount;
import com.example.chat.model.User;
import com.example.chat.model.UserResponse;
import com.example.chat.service.UserService;

/**
 * ユーザー情報取得コントローラー
 * 
 * @author tk
 */
@RestController
public class UserController {

	/** ユーザー情報取得サービス */
	private final UserService userService;

	/**
	 * コンストラクタ
	 * 
	 * @param userService ユーザーサービス
	 */
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ユーザー情報取得
	 * 
	 * @param aut 認証情報
	 * @return ユーザー情報
	 * @throws NotFoundException
	 */
	@GetMapping("/user")
	public UserResponse getUser(@AuthenticationPrincipal CustomUserDetails aut) throws NotFoundException{
		return this.userService.getUser(aut.getUsername());

	}

	/**
	 * ユーザーリスト取得
	 * 
	 * @return ユーザーリスト
	 */
	@GetMapping("/users/all")
	public List<UserResponse> getAllUsers() {
		return this.userService.getAllUsers();

	}

	/**
	 * ユーザー情報登録
	 * 
	 * @param userForm ユーザーフォーム
	 * @return 更新件数モデル
	 * @throws ConflictException
	 */
	@PostMapping("/user/signup")
	@CrossOrigin(origins = "http://localhost:8081/")
	public ResultCount signup(@Validated UserForm userForm) throws ConflictException {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.userService.signup(user));
		return resultCount;
	}

	/**
	 * ユーザー情報更新
	 * 
	 * @param userForm ユーザーフォーム
	 * @return 更新件数モデル
	 * @throws PasswordMismatchException
	 */
	@PostMapping("/user/update")
	public ResultCount update(@Validated UserForm userForm) throws ConflictException{
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.userService.update(user));
		return resultCount;
	}

}
