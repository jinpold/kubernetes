package com.james.api.article.model;
import com.james.api.board.model.Board;
import com.james.api.common.model.BaseEntity;
import com.james.api.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "articles")
@AllArgsConstructor

public class Article extends BaseEntity {
    @Id
    @Column(name = "article_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne(fetch = FetchType.LAZY)
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
