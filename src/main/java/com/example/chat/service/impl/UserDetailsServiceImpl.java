package com.example.chat.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chat.model.Authentication;
import com.example.chat.model.CustomUserDetails;
import com.example.chat.repository.LoginRepository;
import com.example.chat.util.MessageCode;

/**
 * ユーザー詳細サービス実装
 *
 * @author tk
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	/** ログインリポジトリ */
	private final LoginRepository loginRepository;

	/**
	 * コンストラクタ
	 * 
	 * @param loginRepository ログインリポジトリ
	 */
	public UserDetailsServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		if (StringUtils.isEmpty(userId)) {
			// 入力されていない場合は例外をスローする。
			throw new UsernameNotFoundException(MessageCode.AUTHENTICATION_FAILURE);
		}
		Authentication auth = loginRepository.getOne(userId);
		if (auth == null) {
			// ユーザーが取得出来なかった場合は例外をスローする。
			throw new UsernameNotFoundException(MessageCode.AUTHENTICATION_FAILURE);
		}

		// UserDetails実装クラスに取得情報を詰め替えて、返却する。
		return new CustomUserDetails(auth.getUserId(), auth.getPassword(), auth.getRole());
	}

}
