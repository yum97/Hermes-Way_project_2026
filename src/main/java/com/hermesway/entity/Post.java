package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 投稿を表すエンティティ
 */
@Entity
@Table(name = "posts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post extends BaseEntity {

    // 投稿ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投稿のタイトル
    @Column(nullable = false, length = 200)
    private String title;

    // 投稿の内容
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 投稿の旅行開始日
    @Column(nullable = false)
    private LocalDate travelStartDate;

    // 投稿の旅行終了日
    @Column(nullable = false)
    private LocalDate travelEndDate;

    // 投稿の旅行期間（日数）
    @Column(nullable = false)
    private Integer travelDuration;

    // 投稿の閲覧数
    @Column(nullable = false)
    @Builder.Default
    private Long viewCount = 0L;

    // 投稿のいいね数
    @Column(nullable = false)
    @Builder.Default
    private Long likeCount = 0L;

    // 投稿のコメント数
    @Column(nullable = false)
    @Builder.Default
    private Long commentCount = 0L;

    // 投稿の作成者（ユーザー）
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User author;

    // 投稿の画像のリスト
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<PostImage> images = new ArrayList<>();

    // 投稿の場所のリスト
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<PostPlace> places = new ArrayList<>();

    // 投稿のハッシュタグのリスト
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<PostHashtag> hashtags = new ArrayList<>();

    // 投稿の旅行スタイルのリスト
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<PostTravelStyle> travelStyles = new ArrayList<>();
}