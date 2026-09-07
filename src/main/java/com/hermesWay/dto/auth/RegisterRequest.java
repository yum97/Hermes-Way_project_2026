package com.hermesway.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 新規会員登録時にクライアントから受け取るリクエストDTO
 */
@Getter
@NoArgsConstructor
public class RegisterRequest {

    // 登録するメールアドレス
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    // ログインに使用するパスワード
    @NotBlank
    @Size(min = 8, max = 255)
    private String password;

    // ユーザーに表示するニックネーム
    @NotBlank
    @Size(max = 50)
    private String nickname;

    // ユーザーの本名
    @NotBlank
    @Size(max = 100)
    private String name;

    // プロフィール画像URL
    @Size(max = 500)
    private String profileImage;

    // 自己紹介
    @Size(max = 1000)
    private String bio;

    // 住所
    @Size(max = 255)
    private String address;
}