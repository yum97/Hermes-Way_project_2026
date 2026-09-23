package com.hermesway.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * コメント作成時にクライアントから受け取るリクエストDTO
 */
@Getter
@NoArgsConstructor
public class CommentCreateRequest {

    // コメント本文
    @NotBlank
    @Size(max = 2000)
    private String content;

    // 親コメントID
    // nullの場合は通常コメント、値がある場合は返信
    private Long parentId;
}