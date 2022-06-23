package com.example.chat.repository.impl;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.exception.NotFoundException;
import com.example.chat.model.PasswordUpdate;
import com.example.chat.model.User;
import com.example.chat.model.UserResponse;
import com.example.chat.repository.UserRepository;
import com.example.chat.repository.mapper.UserMapper;
import com.example.chat.util.MessageCode;

/**
 * ユーザー情報取得リポジトリ
 * 
 * @author tk
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	/** ユーザー情報取得マッパー */
	private final UserMapper userMapper;

	/** 埋め込み文字_ユーザーID */
	private static final String ARG_USER_ID = "ユーザーID";

	/**
	 * コンストラクタ
	 * 
	 * @param userInfGetMapper ユーザー情報取得マッパー
	 */
	public UserRepositoryImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserResponse select(String userId) {
		UserResponse user = this.userMapper.select(userId);
		if (user == null) {
			throw new NotFoundException(MessageCode.NOT_FOUND);
		}
		return this.userMapper.select(userId);
	}

	@Override
	public List<UserResponse> selectAll() {
		return this.userMapper.selectAll();
	}

	@Override
	public int insert(User signUp) {
		try {
			return this.userMapper.insert(signUp);
		} catch (DuplicateKeyException e) {
			throw new ConflictException(ARG_USER_ID, MessageCode.CONFLICT_INSERT, e);
		}
	}

	@Override
	public int update(User user) {

		return this.userMapper.update(user);
	}

	@Override
	public int delete(User user) {
		int resultCount = this.userMapper.delete(user);
		if (resultCount == 0) {
			throw new NotFoundException(MessageCode.NOT_FOUND);
		}
		return resultCount;
	}

	@Override
	public int updatePassword(PasswordUpdate passwordUpdate) {
		return this.userMapper.updatePassword(passwordUpdate);
	}

	@Override
	public String selectPassword(String userId) {
		return this.userMapper.selectPassword(userId);
	}

}
