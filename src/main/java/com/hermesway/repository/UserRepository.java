package com.hermesway.repository;

import com.hermesway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ユーザー情報をデータベースから取得するRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    // メールアドレスでユーザーを検索
    Optional<User> findByEmail(String email);

    // メールアドレスの重複確認
    boolean existsByEmail(String email);

    // ニックネームの重複確認
    boolean existsByNickname(String nickname);
}