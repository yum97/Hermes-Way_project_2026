package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿と旅行スタイルの関連を表すエンティティ
 */
@Entity
@Table(
        name = "post_travel_styles",
        uniqueConstraints = {
            // 投稿IDと旅行スタイルIDの組み合わせの一意制約
                @UniqueConstraint(
                        name = "uk_post_travel_style",
                        columnNames = {"post_id", "travel_style_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostTravelStyle extends BaseEntity {

    // 投稿旅行スタイルID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿と旅行スタイル
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // 投稿と旅行スタイルの関連を表すための多対一のリレーションシップ
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "travel_style_id")
    private TravelStyle travelStyle;
}