package com.hermesway.dto.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * 投稿編集時にクライアントから受け取るリクエストDTO
 */
@Getter
@NoArgsConstructor
public class PostUpdateRequest {

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
    private List<PostCreateRequest.PostImageRequest> images;

    // 投稿に関連付ける場所
    @Valid
    private List<PostCreateRequest.PostPlaceRequest> places;

    // ハッシュタグ名
    private List<String> hashtags;

    // 旅行スタイルID
    private List<Long> travelStyleIds;
}