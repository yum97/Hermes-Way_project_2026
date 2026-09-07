package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿といいねの関連を表すエンティティ
 */
@Entity
@Table(
        name = "post_likes",
        uniqueConstraints = {
            // 投稿IDとユーザーIDの組み合わせの一意制約
                @UniqueConstraint(
                        name = "uk_post_like",
                        columnNames = {"user_id", "post_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostLike extends BaseEntity {

    // 投稿いいねID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿といいねの関連
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    // 投稿といいねの関連
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}