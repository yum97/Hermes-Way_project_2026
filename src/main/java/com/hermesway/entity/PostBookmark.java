package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿とブックマークの関連を表すエンティティ
 */
@Entity
@Table(
        name = "post_bookmarks",
        uniqueConstraints = {
            // 投稿IDとユーザーIDの組み合わせの一意制約
                @UniqueConstraint(
                        name = "uk_post_bookmark",
                        columnNames = {"user_id", "post_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostBookmark extends BaseEntity {

    // 投稿ブックマークID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿とブックマークの関連
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    // 投稿とブックマークの関連
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}