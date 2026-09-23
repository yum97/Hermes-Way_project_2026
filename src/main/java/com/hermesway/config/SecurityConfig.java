package com.hermesway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Securityの設定
 */
@Configuration
public class SecurityConfig {

    /**
     * パスワードの暗号化・照合に使用
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Spring SecurityのHTTPセキュリティ設定
     * 
     * @param http HttpSecurityオブジェクト
     * @return SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                // REST API開発段階ではCSRFを無効化
                // 本番環境ではCookie認証に合わせて再設定する
                .csrf(csrf -> csrf.disable())

                // Spring Security標準のログイン画面を使用しない
                .formLogin(form -> form.disable())

                // HTTP Basic認証も使用しない
                .httpBasic(basic -> basic.disable())

                // APIのアクセス権限
                .authorizeHttpRequests(auth -> auth

                        // ログイン・会員登録は未ログインでも許可
                        .requestMatchers(
                                "/api/auth/login",
                                "/api/auth/register"
                        ).permitAll()

                        // 現段階ではその他も許可
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}