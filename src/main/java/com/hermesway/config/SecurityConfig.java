package com.hermesway.config;

import com.hermesway.security.JwtFilter;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Securityの設定
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    /**
     * パスワード暗号化
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Security設定
     */
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                // JWT認証を使用するためCSRFを一旦無効化
                .csrf(csrf -> csrf.disable())

                // Spring Security標準ログイン画面を無効化
                .formLogin(form -> form.disable())

                // Basic認証を無効化
                .httpBasic(basic -> basic.disable())

                // JWTを使用するためSessionを作成しない
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                // APIアクセス権限
                .authorizeHttpRequests(auth -> auth

                        // ログイン前でもアクセス可能
                        .requestMatchers(
                                "/api/auth/login",
                                "/api/auth/register",
                                "/api/auth/logout"
                        ).permitAll()

                        // ログイン済みユーザーのみアクセス可能
                        .requestMatchers(
                                "/api/auth/me"
                        ).authenticated()

                        // 現在はその他のAPIを許可
                        .anyRequest().permitAll()
                )

                // JWT認証フィルターを実行
                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}