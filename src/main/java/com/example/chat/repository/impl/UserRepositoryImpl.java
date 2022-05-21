package com.example.chat.repository.impl;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.User;
import com.example.chat.model.UserResponse;
import com.example.chat.repository.UserRepository;
import com.example.chat.repository.mapper.UserMapper;

/**
 * ユーザー情報取得リポジトリ
 * 
 * @author tk
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	/** ユーザー情報取得マッパー */
	private final UserMapper userMapper;

	/**
	 * コンストラクタ
	 * 
	 * @param userInfGetMapper ユーザー情報取得マッパー
	 */
	public UserRepositoryImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserResponse select(String userId) throws NotFoundException {
		UserResponse user = this.userMapper.select(userId);
		if (user == null) {
			throw new NotFoundException("e.chat.notFound");
		}
		return this.userMapper.select(userId);
	}

	@Override
	public List<UserResponse> selectAll() {
		return this.userMapper.selectAll();
	}

	@Override
	public int insert(User signUp) throws ConflictException {
		try {
			return this.userMapper.insert(signUp);
		} catch (DuplicateKeyException e) {
			throw new ConflictException("userId", "e.chat.conflict", e);
		}
	}

	@Override
	public int update(User user) throws ConflictException {
		try {
			return this.userMapper.update(user);
		} catch (DuplicateKeyException e) {
			throw new ConflictException("userId", "e.chat.conflict", e);
		}
	}

}
