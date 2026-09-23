package com.hermesway.dto.user;

import com.hermesway.entity.User;
import lombok.Builder;
import lombok.Getter;

/**
 * 公開プロフィール情報をクライアントへ返すレスポンスDTO
 */
@Getter
@Builder
public class ProfileResponse {

    // ユーザーID
    private Long id;

    // ニックネーム
    private String nickname;

    // プロフィール画像URL
    private String profileImage;

    // 自己紹介
    private String bio;

    /**
     * UserエンティティをProfileResponse DTOへ変換する
     */
    public static ProfileResponse from(User user) {
        return ProfileResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .profileImage(user.getProfileImage())
                .bio(user.getBio())
                .build();
    }
}