package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 国を表すエンティティ
 */
@Entity
@Table(name = "countries")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Country extends BaseEntity {

    // 国ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 国の名前
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    // 国のコード
    @Column(nullable = false, unique = true, length = 10)
    private String code;
}

/**
 * 初期データとして以下の国を登録することを想定している。
 * 
 * Japan / JP
 * Korea / KR
 * Taiwan / TW
 */