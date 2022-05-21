package com.example.chat.service.impl;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.chat.exception.ConflictException;
import com.example.chat.model.User;
import com.example.chat.model.UserResponse;
import com.example.chat.repository.UserRepository;
import com.example.chat.service.UserService;
import com.example.chat.util.Constant;
import com.example.chat.util.Util;

/**
 * ユーザー情報取得サービス実装
 * 
 * @author tk
 */
@Service
public class UserServiceImpl implements UserService {

	/** ユーザー情報取得リポジトリ */
	private final UserRepository userRepository;

	/** パスワードエンコーダー */
	private final BCryptPasswordEncoder passwordEncoder;

	/**
	 * コンストラクタ
	 * 
	 * @param userInfGetRepository ユーザー情報取得リポジトリ
	 * @param passwordEncoder      パスワードエンコーダー
	 */
	public UserServiceImpl(UserRepository userInfGetRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userInfGetRepository;
		this.passwordEncoder = passwordEncoder;

	}

	@Override
	public UserResponse getUser(String userId) throws NotFoundException {
		return this.userRepository.select(userId);
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return this.userRepository.selectAll();
	}

	@Override
	public int signup(User user) throws ConflictException {

		String strNowDate = Util.getStrNowDate();

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Constant.ROLE_USER);
		user.setInsDt(strNowDate);
		user.setUpdDt(strNowDate);

		return this.userRepository.insert(user);
	}

	@Override
	public int update(User user) throws ConflictException {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUpdDt(Util.getStrNowDate());

		return this.userRepository.update(user);
	}
}