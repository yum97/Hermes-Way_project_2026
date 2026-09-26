package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * ハッシュタグを表すエンティティ
 */
@Entity
@Table(name = "hashtags")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Hashtag extends BaseEntity {

    // ハッシュタグID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ハッシュタグの名前
    @Column(nullable = false, unique = true, length = 100)
    private String name;
}