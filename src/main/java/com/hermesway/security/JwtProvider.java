package com.hermesway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import java.util.Date;

/**
 * JWTの生成・解析・検証を担当するクラス
 */
@Component
public class JwtProvider {

    // JWT署名用の秘密鍵
    private final SecretKey secretKey;

    // アクセストークンの有効期限：1時間
    private static final long ACCESS_TOKEN_EXPIRATION =
            1000L * 60 * 60;

    /**
     * application.propertiesから秘密鍵を取得する
     *
     * @param secret JWT署名用の秘密鍵
     */
    public JwtProvider(
            @Value("${jwt.secret}") String secret
    ) {

        // Base64でエンコードされた秘密鍵をデコードしてSecretKeyを生成
        byte[] keyBytes = Decoders.BASE64.decode(secret);

        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * JWTアクセストークンを生成する
     *
     * @param email ログインユーザーのメールアドレス
     * @return JWTアクセストークン
     */
    public String createAccessToken(String email) {

        Date now = new Date();

        // アクセストークンの有効期限を設定
        Date expiration = new Date(
                now.getTime() + ACCESS_TOKEN_EXPIRATION
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(secretKey)
                .compact();
    }

    /**
     * JWTからメールアドレスを取得する
     *
     * @param token JWTアクセストークン
     * @return メールアドレス
     */
    public String getEmail(String token) {

        // JWTを解析してClaimsを取得
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    /**
     * JWTが有効か確認する
     *
     * @param token JWTアクセストークン
     * @return 有効な場合true
     */
    public boolean validateToken(String token) {

        try {

            // JWTを解析して有効性を確認
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}