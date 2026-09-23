package com.hermesway.dto.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * 新規投稿作成時にクライアントから受け取るリクエストDTO
 */
@Getter
@NoArgsConstructor
public class PostCreateRequest {

    // 投稿タイトル
    @NotBlank
    @Size(max = 200)
    private String title;

    // 投稿本文
    @NotBlank
    private String content;

    // 旅行開始日
    @NotNull
    private LocalDate travelStartDate;

    // 旅行終了日
    @NotNull
    private LocalDate travelEndDate;

    // 投稿画像
    @Valid
    @Size(max = 10)
    private List<PostImageRequest> images;

    // 投稿に関連付ける場所
    @NotEmpty
    @Valid
    private List<PostPlaceRequest> places;

    // ハッシュタグ名
    private List<String> hashtags;

    // 旅行スタイルID
    private List<Long> travelStyleIds;

    /**
     * 投稿画像の登録情報
     */
    @Getter
    @NoArgsConstructor
    public static class PostImageRequest {

        // 画像URL
        @NotBlank
        @Size(max = 500)
        private String imageUrl;

        // 画像の表示順
        @NotNull
        private Integer displayOrder;

        // カバー画像かどうか
        @NotNull
        private Boolean coverImage;
    }

    /**
     * 投稿と場所を関連付けるための情報
     */
    @Getter
    @NoArgsConstructor
    public static class PostPlaceRequest {

        // 関連付ける場所ID
        @NotNull
        private Long placeId;

        // 場所に対するコミュニティ評価
        @NotNull
        @Min(1)
        @Max(5)
        private Integer rating;
    }
}