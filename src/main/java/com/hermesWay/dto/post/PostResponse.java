package com.hermesway.dto.post;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 投稿詳細情報をクライアントへ返すレスポンスDTO
 */
@Getter
@Builder
public class PostResponse {

    // 投稿ID
    private Long id;

    // 投稿タイトル
    private String title;

    // 投稿本文
    private String content;

    // 旅行開始日
    private LocalDate travelStartDate;

    // 旅行終了日
    private LocalDate travelEndDate;

    // 旅行日数
    private Integer travelDuration;

    // 閲覧数
    private Long viewCount;

    // いいね数
    private Long likeCount;

    // コメント数
    private Long commentCount;

    // 投稿者ID
    private Long authorId;

    // 投稿者ニックネーム
    private String authorNickname;

    // 投稿者プロフィール画像
    private String authorProfileImage;

    // 投稿画像
    private List<PostImageResponse> images;

    // 関連する場所
    private List<PostPlaceResponse> places;

    // ハッシュタグ
    private List<String> hashtags;

    // 旅行スタイル
    private List<String> travelStyles;

    // 投稿作成日時
    private LocalDateTime createdAt;

    // 投稿更新日時
    private LocalDateTime updatedAt;

    /**
     * 投稿画像情報
     */
    @Getter
    @Builder
    public static class PostImageResponse {

        // 画像ID
        private Long id;

        // 画像URL
        private String imageUrl;

        // 画像の表示順
        private Integer displayOrder;

        // カバー画像かどうか
        private Boolean coverImage;
    }

    /**
     * 投稿と場所の関連情報
     */
    @Getter
    @Builder
    public static class PostPlaceResponse {

        // 場所ID
        private Long placeId;

        // 場所名
        private String placeName;

        // 場所カテゴリー
        private String category;

        // 地域名
        private String regionName;

        // 国名
        private String countryName;

        // コミュニティ評価
        private Integer rating;
    }
}