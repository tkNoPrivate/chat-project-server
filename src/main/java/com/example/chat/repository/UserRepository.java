package com.example.chat.repository;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.PasswordUpdate;
import com.example.chat.model.User;
import com.example.chat.model.UserResponse;

/**
 * ユーザー情報取得リポジトリ
 * 
 * @author tk
 */
public interface UserRepository {

	/**
	 * ユーザー情報取得
	 * 
	 * @param userId ユーザーID
	 * @return ユーザー情報
	 * @throws NotFoundException
	 */
	UserResponse select(String userId) throws NotFoundException;

	/**
	 * 全ユーザー情報リスト取得
	 * 
	 * @return ユーザー情報リストÏ
	 */
	List<UserResponse> selectAll();

	/**
	 * ユーザー情報登録
	 * 
	 * @param user ユーザーモデル
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int insert(User user) throws ConflictException;

	/**
	 * ユーザー情報更新
	 * 
	 * @param user ユーザー
	 * @return 更新件数
	 * @throws ConflictException
	 */
	int update(User user) throws ConflictException;
	
	/**
	 * パスワード取得
	 * 
	 * @param userId ユーザーID
	 * @return パスワード
	 */
	String selectPassword(String userId);
	
	/**
	 * パスワード更新
	 * 
	 * @param passwordUpdate パスワード更新モデル
	 * @return 更新件数
	 */
	int updatePassword(PasswordUpdate passwordUpdate);

}
