package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 場所を表すエンティティ
 */
@Entity
@Table(
        name = "places",
        uniqueConstraints = {
            // Google Place IDの一意制約
                @UniqueConstraint(
                        name = "uk_place_google_place_id",
                        columnNames = "google_place_id"
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Place extends BaseEntity {

    // 場所ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 場所の名前
    @Column(nullable = false, length = 255)
    private String name;

    // 場所のカテゴリ
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PlaceCategory category;

    // 場所の地域
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id")
    private Region region;

    // Google Place ID
    @Column(name = "google_place_id", nullable = false, length = 255)
    private String googlePlaceId;

    // 場所の住所
    @Column(length = 500)
    private String address;

    // 場所の電話番号
    @Column(length = 50)
    private String phone;

    // 場所のウェブサイト
    @Column(length = 500)
    private String website;

    // 場所の緯度
    private Double latitude;

    // 場所の経度
    private Double longitude;

    // Googleの評価
    private Double googleRating;

    // Googleのレビュー
    @Column(length = 2000)
    private String openingHours;
}