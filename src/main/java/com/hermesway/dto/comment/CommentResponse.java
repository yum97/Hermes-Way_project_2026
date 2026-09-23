package com.hermesway.dto.comment;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * コメント情報をクライアントへ返すレスポンスDTO
 */
@Getter
@Builder
public class CommentResponse {

    // コメントID
    private Long id;

    // コメント本文
    private String content;

    // 投稿者ID
    private Long authorId;

    // 投稿者ニックネーム
    private String authorNickname;

    // 投稿者プロフィール画像
    private String authorProfileImage;

    // 親コメントID
    private Long parentId;

    // 返信一覧
    private List<CommentResponse> replies;

    // コメント作成日時
    private LocalDateTime createdAt;

    // コメント更新日時
    private LocalDateTime updatedAt;
}