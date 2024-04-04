package com.james.api.board;
import com.james.api.article.Article;
import com.james.api.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name="boards")

public class Board extends BaseEntity {
    @Id
    @Column(name = "board_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "board_name")
    private String boardName;
    @Column(name = "board_type")
    private String boardType;

    @OneToMany(mappedBy = "board")
    private List<Article> article;

    @Builder(builderMethodName = "builder")
    public Board(Long id, String boardName, String boardType) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
