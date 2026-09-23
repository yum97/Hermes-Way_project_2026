package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿の申告を表すエンティティ
 */
@Entity
@Table(name = "reports")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Report extends BaseEntity {

    // 申告ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 申告者（ユーザー）
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reporter_id")
    private User reporter;

    // 申告対象の投稿
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // 申告理由
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ReportReason reason;

    // 申告のステータス
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private ReportStatus status = ReportStatus.REVIEWING;

    // 申告の詳細説明（任意）
    @Column(length = 1000)
    private String description;

    // 申告のステータスを更新するメソッド
    public enum ReportReason {
        SPAM,
        ABUSIVE_LANGUAGE,
        INAPPROPRIATE_CONTENT,
        FALSE_INFORMATION,
        PERSONAL_INFORMATION,
        OTHER
    }

    // 申告のステータスを表す列挙型
    public enum ReportStatus {
        REVIEWING,
        NORMAL,
        DELETED
    }
}