package com.james.api.article;
import com.james.api.board.Board;
import com.james.api.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "articles")

public class Article {
    @Id
    @Column(name = "article_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @Column(name = "register_date")
        private String registerDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content, User writer, String registerDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registerDate = registerDate;
    }
}
