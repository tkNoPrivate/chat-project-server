package com.example.chat.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.exception.ConfirmPasswordMismatchException;
import com.example.chat.exception.ConflictException;
import com.example.chat.model.PasswordUpdate;
import com.example.chat.model.User;
import com.example.chat.model.UserResponse;
import com.example.chat.repository.UserRepository;
import com.example.chat.service.UserService;
import com.example.chat.util.Constant;
import com.example.chat.util.MessageCode;
import com.example.chat.util.Util;

/**
 * ユーザー情報取得サービス実装
 * 
 * @author tk
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	/** ユーザー情報取得リポジトリ */
	private final UserRepository userRepository;

	/** パスワードエンコーダー */
	private final BCryptPasswordEncoder passwordEncoder;

	/** 埋め込み文字_ユーザー */
	private static final String ARG_USER = "ユーザー";

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
	public UserResponse getUser(String userId) {
		return this.userRepository.select(userId);
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return this.userRepository.selectAll();
	}

	@Override
	public int signup(User user) {

		String strNowDate = Util.getStrNowDate();

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Constant.ROLE_USER);
		user.setInsDt(strNowDate);
		user.setUpdDt(strNowDate);

		return this.userRepository.insert(user);
	}

	@Override
	public int update(User user) {
		this.checkOptimisticLock(user);
		user.setUpdDt(Util.getStrNowDate());
		return this.userRepository.update(user);
	}

	@Override
	public int delete(User user) {
		this.checkOptimisticLock(user);
		return this.userRepository.delete(user);
	}

	@Override
	public int updatePassword(PasswordUpdate passwordUpdate) {
		String password = this.userRepository.selectPassword(passwordUpdate.getUserId());
		// 現在のパスワードが正しいかチェックする
		if (!passwordEncoder.matches(passwordUpdate.getPassword(), password)) {
			throw new ConfirmPasswordMismatchException(MessageCode.CONFILM_PASSWORD_MISMATCH);
		}
		passwordUpdate.setNewPassword(passwordEncoder.encode(passwordUpdate.getNewPassword()));
		passwordUpdate.setUpdDt(Util.getStrNowDate());
		return this.userRepository.updatePassword(passwordUpdate);
	}

	private void checkOptimisticLock(User user) {
		UserResponse userResponse = this.userRepository.select(user.getUserId());
		if (!user.getUpdDt().equals(userResponse.getUpdDt())) {
			throw new ConflictException(ARG_USER, MessageCode.CONFLICT_UPDATE);
		}
	}

}
