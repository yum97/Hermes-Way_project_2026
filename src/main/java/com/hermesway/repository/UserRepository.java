package com.hermesway.repository;

import com.hermesway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// ユーザー情報をデータベースから取得するRepository
public interface UserRepository extends JpaRepository<User, Long> {

    // メールアドレスからユーザーを検索
    Optional<User> findByEmail(String email);

    // メールアドレスが既に登録されているか確認
    boolean existsByEmail(String email);
}