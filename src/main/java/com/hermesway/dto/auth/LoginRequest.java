package com.hermesway.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ログイン時にクライアントから受け取るリクエストDTO
 */
@Getter
@NoArgsConstructor
public class LoginRequest {

    // ログインに使用するメールアドレス
    @NotBlank
    @Email
    private String email;

    // ログインに使用するパスワード
    @NotBlank
    private String password;
}