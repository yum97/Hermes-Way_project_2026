package com.hermesway.controller;

import com.hermesway.dto.auth.LoginRequest;
import com.hermesway.service.AuthService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ログイン・認証関連のAPIを提供するコントローラー
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * ログインエンドポイント
     *
     * @param request クライアントからのログインリクエストDTO
     * @param response HTTPレスポンスオブジェクト
     * @return ログイン成功時のレスポンス
     */
    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response
    ) {

        authService.login(request, response);

        return ResponseEntity.ok().build();
    }

    /**
     * ログアウトエンドポイント
     *
     * @param response HTTPレスポンスオブジェクト
     * @return ログアウト成功時のレスポンス
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            HttpServletResponse response
    ) {

        authService.logout(response);

        return ResponseEntity.ok().build();
    }
}