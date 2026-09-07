package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 禁止ワードを表すエンティティ
 */
@Entity
@Table(name = "banned_words")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BannedWord extends BaseEntity {

    // 禁止ワードID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 禁止ワードの文字列
    @Column(nullable = false, unique = true, length = 100)
    private String word;

    // 禁止ワードが有効かどうかを示すフラグ
    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;
}