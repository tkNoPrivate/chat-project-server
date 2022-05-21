package com.example.chat.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.User;
import com.example.chat.model.UserResponse;

/**
 * ユーザーマッパー
 * 
 * @author tk
 */
@Mapper
public interface UserMapper {

	/**
	 * ユーザー情報取得
	 * 
	 * @param userId ユーザーID
	 * @return ユーザー情報
	 */
	UserResponse select(String userId);

	/**
	 * 全ユーザー情報リスト取得
	 * 
	 * @return ユーザー情報リスト
	 */
	List<UserResponse> selectAll();
	
	/**
	 * ユーザー情報登録
	 * 
	 * @param user ユーザーモデル
	 * @return 更新件数
	 */
	int insert(User user);
	
	/**
	 * ユーザー情報更新
	 * 
	 * @param user ユーザーモデル
	 * @return 更新件数
	 */
	int update(User user);

}