package com.example.chat.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.chat.model.Authentication;
import com.example.chat.repository.LoginRepository;
import com.example.chat.repository.mapper.LoginMapper;

/**
 * ログインリポジトリ実装
 *
 * @author tk
 *
 */
@Repository
public class LoginRepositoryImpl implements LoginRepository {

	/** ログインマッパー */
	private final LoginMapper loginMapper;

	/**
	 * コンストラクタ
	 * 
	 * @param loginMapper ログインマッパー
	 */
	public LoginRepositoryImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	@Override
	public Authentication getOne(String userId) {

		return loginMapper.getOne(userId);
	}
}
