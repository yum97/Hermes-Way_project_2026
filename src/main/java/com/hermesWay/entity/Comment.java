package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * コメントを表すエンティティ
 */
@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Comment extends BaseEntity {

    // コメントID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // コメントの内容
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // コメントの著者
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User author;

    // コメントが属する投稿
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // 親コメント（返信元のコメント）
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    // 返信コメント（親コメントに対する返信）
    @OneToMany(mappedBy = "parent")
    @Builder.Default
    private List<Comment> replies = new ArrayList<>();
}