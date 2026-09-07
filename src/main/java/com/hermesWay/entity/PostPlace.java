package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿と場所の関連を表すエンティティ
 */
@Entity
@Table(
        name = "post_places",
        uniqueConstraints = {
            // 投稿IDと場所IDの組み合わせの一意制約
                @UniqueConstraint(
                        name = "uk_post_place",
                        columnNames = {"post_id", "place_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostPlace extends BaseEntity {

    // 投稿場所ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿と場所の関連を表すための多対一のリレーションシップ
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // 投稿と場所の関連を表すための多対一のリレーションシップ
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "place_id")
    private Place place;

    // 投稿と場所の関連の評価
    @Column(nullable = false)
    private Integer rating;
}