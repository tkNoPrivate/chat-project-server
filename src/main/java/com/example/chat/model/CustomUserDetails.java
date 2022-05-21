package com.example.chat.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * ユーザー詳細実装
 *
 * @author tk
 */
public class CustomUserDetails implements UserDetails {

    /** ユーザー名 */
    private String userId;

    /** パスワード */
    private String password;

    /** 権限リスト */
    private Collection<? extends GrantedAuthority> authorityList;

    /**
     * コンストラクタ
     *
     * @param userId ユーザー名
     * @param password パスワード
     * @param authority 権限リスト
     */
    public CustomUserDetails(String userId, String password, String authority) {

        this.userId = userId;
        this.password = password;
        Collection<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(authority));
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    @Override
	public String getUsername() {
		return this.userId;
	}

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
