package com.example.chat.repository;

import com.example.chat.model.Authentication;

/**
 * ログインリポジトリ
 *
 * @author tk
 */
public interface LoginRepository {

    /**
     * 認証情報取得処理
     *
     * @param userId ユーザーID
     * @return 認証情報
     */
    Authentication getOne(String userId);

}
