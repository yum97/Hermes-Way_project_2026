package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿とハッシュタグの関連を表すエンティティ
 */
@Entity
@Table(
        name = "post_hashtags",
        uniqueConstraints = {
            // 投稿IDとハッシュタグIDの組み合わせの一意制約
                @UniqueConstraint(
                        name = "uk_post_hashtag",
                        columnNames = {"post_id", "hashtag_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostHashtag extends BaseEntity {

    // 投稿ハッシュタグID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿とハッシュタグの関連を表すための多対一のリレーションシップ
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // 投稿とハッシュタグの関連を表すための多対一のリレーションシップ
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;
}