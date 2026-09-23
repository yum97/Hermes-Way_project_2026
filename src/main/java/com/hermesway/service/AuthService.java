package com.hermesway.service;

import com.hermesway.dto.auth.LoginRequest;
import com.hermesway.entity.User;
import com.hermesway.repository.UserRepository;
import com.hermesway.security.JwtProvider;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 認証関連のビジネスロジックを管理するサービス
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    /**
     * ログイン処理
     *
     * @param request クライアントからのログインリクエストDTO
     * @param response HTTPレスポンスオブジェクト
     */
    public void login(
            LoginRequest request,
            HttpServletResponse response
    ) {

        // メールアドレスからユーザーを検索
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "メールアドレスまたはパスワードが正しくありません。"
                        )
                );

        // 入力されたパスワードとDBに保存されたパスワードを照合
        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        // パスワードが一致しない場合
        if (!passwordMatches) {
            throw new IllegalArgumentException(
                    "メールアドレスまたはパスワードが正しくありません。"
            );
        }

        // JWTアクセストークンを生成
        String accessToken =
                jwtProvider.createAccessToken(user.getEmail());

        // JWTをHttpOnly Cookieに保存
        Cookie cookie = new Cookie(
                "accessToken",
                accessToken
        );

        cookie.setHttpOnly(true);

        // 開発環境ではfalse、本番HTTPS環境ではtrue
        cookie.setSecure(false);

        // サイト全体でCookieを使用
        cookie.setPath("/");

        // Cookieの有効期限：1時間
        cookie.setMaxAge(60 * 60);

        response.addCookie(cookie);

        System.out.println(
                "ログイン成功: " + user.getEmail()
        );
    }

    /**
     * ログアウト処理
     *
     * @param response HTTPレスポンスオブジェクト
     */
    public void logout(HttpServletResponse response) {

        // JWT Cookieを削除する
        Cookie cookie = new Cookie(
                "accessToken",
                ""
        );

        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");

        // Cookieを即時削除
        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }
}