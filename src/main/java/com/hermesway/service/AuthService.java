package com.hermesway.service;

import com.hermesway.dto.auth.LoginRequest;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

/**
 * 認証関連のビジネスロジックを管理するサービス
 */
@Service
public class AuthService {

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

        /*
         * TODO:
         * 1. メールアドレスでユーザーを検索
         * 2. BCryptでパスワードを確認
         * 3. JWTを生成
         * 4. HttpOnly CookieにJWTを保存
         */

        System.out.println("ログイン要求: " + request.getEmail());
    }

    /**
     * ログアウト処理
     *
     * @param response HTTPレスポンスオブジェクト
     */
    public void logout(HttpServletResponse response) {

        // JWT Cookieを削除する
        Cookie cookie = new Cookie("accessToken", "");

        cookie.setHttpOnly(true);
        cookie.setSecure(false); // 開発環境ではfalse、本番環境ではtrue
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }
}