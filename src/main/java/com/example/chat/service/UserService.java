package com.example.chat.service;

import java.util.List;

import com.example.chat.exception.ConfirmPasswordMismatchException;
import com.example.chat.exception.ConflictException;
import com.example.chat.model.PasswordUpdate;
import com.example.chat.model.User;
import com.example.chat.model.UserResponse;

/**
 * ユーザー情報取得サービス
 * 
 * @author tk
 */
public interface UserService {

	/**
	 * ユーザー情報取得
	 * 
	 * @param userId ユーザーID
	 * @return ユーザー情報
	 */
	UserResponse getUser(String userId);

	/**
	 * ユーザー検索
	 * 
	 * @return ユーザー情報リスト
	 */
	List<UserResponse> getAllUsers();

	/**
	 * ユーザー情報登録処理
	 * 
	 * @param signUp ユーザー情報モデル
	 * @return 更新件数
	 */
	int signup(User signUp);

	/**
	 * ユーザー情報更新
	 * 
	 * @param user ユーザーモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int update(User user);

	/**
	 * ユーザー情報削除
	 * 
	 * @param user ユーザーモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int delete(User user);

	/**
	 * パスワード更新
	 * 
	 * @param passwordUpdate パスワード更新モデル
	 * @return 更新件数
	 * @throws ConfirmPasswordMismatchException
	 */
	int updatePassword(PasswordUpdate passwordUpdate);

}
