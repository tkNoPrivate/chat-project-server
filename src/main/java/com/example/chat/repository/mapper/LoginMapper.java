package com.example.chat.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.chat.model.Authentication;

/**
 * ログインマッパー
 *
 * @author tk
 */
@Mapper
public interface LoginMapper {

    /**
     * 認証情報取得処理
     *
     * @param userId ユーザーID
     * @return 認証情報
     */
    Authentication getOne(String userId);
}
