package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * ユーザーを表すエンティティ
 */
@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    // ユーザーID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ユーザーのメールアドレス
    @Column(nullable = false, unique = true, length = 255)
    private String email;

    // ユーザーのパスワード
    @Column(length = 255)
    private String password;

    // ユーザーのニックネーム
    @Column(nullable = false, unique = true, length = 50)
    private String nickname;

    // ユーザーの名前
    @Column(nullable = false, length = 100)
    private String name;

    // ユーザーのプロフィール画像のURL
    @Column(length = 500)
    private String profileImage;

    // ユーザーの自己紹介
    @Column(length = 1000)
    private String bio;

    // ユーザーの住所
    @Column(length = 255)
    private String address;

    // ユーザーの権限
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private Role role = Role.USER;

    // ユーザーのステータス
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private Status status = Status.ACTIVE;

    // ユーザーのアカウントが一時停止された日時
    private LocalDateTime suspensionStartedAt;

    // ユーザーのアカウントの一時停止が解除された日時
    private LocalDateTime suspensionEndedAt;

    // ユーザーの権限
    public enum Role {
        USER,
        ADMIN
    }

    // ユーザーのステータス
    public enum Status {
        ACTIVE,
        SUSPENDED,
        WITHDRAWN
    }
}