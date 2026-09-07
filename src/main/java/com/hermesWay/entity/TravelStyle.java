package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 旅行スタイルを表すエンティティ
 */
@Entity
@Table(name = "travel_styles")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TravelStyle extends BaseEntity {

    // 旅行スタイルID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 旅行スタイルの名前
    @Column(nullable = false, unique = true, length = 50)
    private String name;
}

/**
 * 初期データとして以下の旅行スタイルを登録することを想定している。
 * 
 * グルメ
 * 観光
 * ショッピング
 * 自然
 * 文化・歴史
 * アクティビティ
 * カップル旅行
 * 家族旅行
 * 一人旅
 * 友達旅行
 * その他
 */