package com.hermesway.dto.auth;

import com.hermesway.entity.User;
import lombok.Builder;
import lombok.Getter;

/**
 * 認証済みユーザーの情報をクライアントへ返すレスポンスDTO
 */
@Getter
@Builder
public class UserResponse {

    // ユーザーID
    private Long id;

    // メールアドレス
    private String email;

    // ニックネーム
    private String nickname;

    // 本名
    private String name;

    // プロフィール画像URL
    private String profileImage;

    // 自己紹介
    private String bio;

    // 住所
    private String address;

    // ユーザー権限
    private String role;

    // ユーザー状態
    private String status;

    /**
     * UserエンティティをUserResponse DTOへ変換する
     */
    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .name(user.getName())
                .profileImage(user.getProfileImage())
                .bio(user.getBio())
                .address(user.getAddress())
                .role(user.getRole().name())
                .status(user.getStatus().name())
                .build();
    }
}