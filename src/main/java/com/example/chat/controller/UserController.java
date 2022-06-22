package com.example.chat.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.controller.form.PasswordUpdateForm;
import com.example.chat.controller.form.UserForm;
import com.example.chat.controller.form.UserUpdateForm;
import com.example.chat.model.CustomUserDetails;
import com.example.chat.model.PasswordUpdate;
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
	 */
	@GetMapping("/user")
	public UserResponse getUser(@AuthenticationPrincipal CustomUserDetails aut) {
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
	 */
	@PostMapping("/user/signup")
	@CrossOrigin(origins = "http://localhost:8081/")
	public ResultCount signup(@Validated UserForm userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.userService.signup(user));
		return resultCount;
	}

	/**
	 * ユーザー情報更新
	 * 
	 * @param userUpdateForm ユーザー更新フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/user/update")
	public ResultCount update(@Validated UserUpdateForm userUpdateForm) {
		User user = new User();
		BeanUtils.copyProperties(userUpdateForm, user);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.userService.update(user));
		return resultCount;
	}

	/**
	 * ユーザー情報削除
	 * 
	 * @param userUpdateForm ユーザー更新フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/user/delete")
	public ResultCount delete(@Validated UserUpdateForm userUpdateForm) {
		User user = new User();
		BeanUtils.copyProperties(userUpdateForm, user);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.userService.delete(user));
		return resultCount;
	}

	/**
	 * パスワード更新
	 * 
	 * @param passwordUpdateForm パスワード更新フォーム
	 * @return 更新件数モデル
	 */
	@PostMapping("/user/password/update")
	public ResultCount updatePassword(@Validated PasswordUpdateForm passwordUpdateForm) {
		PasswordUpdate passwordUpdate = new PasswordUpdate();
		BeanUtils.copyProperties(passwordUpdateForm, passwordUpdate);
		ResultCount resultCount = new ResultCount();
		resultCount.setResultCount(this.userService.updatePassword(passwordUpdate));
		return resultCount;
	}

}
