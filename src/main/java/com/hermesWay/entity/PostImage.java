package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 投稿画像を表すエンティティ
 */
@Entity
@Table(name = "post_images")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostImage extends BaseEntity {

    // 投稿画像ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿画像が所属する投稿
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // 投稿画像のURL
    @Column(nullable = false, length = 500)
    private String imageUrl;

    // 投稿画像の表示順序
    @Column(nullable = false)
    private Integer displayOrder;

    // 投稿画像がカバー画像かどうか
    @Column(nullable = false)
    @Builder.Default
    private Boolean coverImage = false;
}