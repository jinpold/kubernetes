package com.james.api.article;

import com.james.api.board.Board;
import com.james.api.common.BaseEntity;
import com.james.api.user.User;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "articles")

public class Article extends BaseEntity {
    @Id
    @Column(name = "article_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, User writer, String content) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
