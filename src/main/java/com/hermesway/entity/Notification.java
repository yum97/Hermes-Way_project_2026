package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 通知を表すエンティティ
 */
@Entity
@Table(name = "notifications")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Notification extends BaseEntity {

    // 通知ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 通知を受け取るユーザー
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    // 通知の種類
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private NotificationType type;

    // 通知のメッセージ
    @Column(nullable = false, length = 255)
    private String message;

    // 通知の対象となるエンティティの種類（例: "Post", "Comment"）
    @Column(length = 50)
    private String targetType;

    // 通知の対象となるエンティティのID
    private Long targetId;

    // 通知が既読かどうかを示すフラグ
    @Column(nullable = false)
    @Builder.Default
    private Boolean isRead = false;

    // 通知の種類を表す列挙型
    public enum NotificationType {
        COMMENT,
        REPLY,
        LIKE
    }
}