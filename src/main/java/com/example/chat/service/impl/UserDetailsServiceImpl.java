package com.example.chat.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.chat.model.Authentication;
import com.example.chat.model.CustomUserDetails;
import com.example.chat.repository.LoginRepository;

/**
 * ユーザー詳細サービス実装
 *
 * @author tk
 */
@Service
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
			// 入力されていない場合は例外をスローする。メッセージは隠蔽される為適当で良い。
			throw new UsernameNotFoundException("error!");
		}
		Authentication auth = loginRepository.getOne(userId);
		if (auth == null) {
			// ユーザーが取得出来なかった場合は例外をスローする。メッセージは隠蔽される為適当で良い。
			throw new UsernameNotFoundException("error!");
		}

		// UserDetails実装クラスに取得情報を詰め替えて、返却する。
		return new CustomUserDetails(auth.getUserId(), auth.getPassword(), auth.getRole());
	}

}
