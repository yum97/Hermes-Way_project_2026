package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿の閲覧を表すエンティティ
 */
@Entity
@Table(name = "post_views")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostView extends BaseEntity {

    // 投稿閲覧ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿とユーザーの関連を表すための多対一のリレーションシップ
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // 投稿とユーザーの関連を表すための多対一のリレーションシップ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}

/**
 * ログインユーザーは → userに保存。
 * ログインしていないユーザーは → userにnullを保存。
 */