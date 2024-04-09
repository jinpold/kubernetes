package com.james.api.board.model;
import com.james.api.article.model.Article;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class BoardDto {

    private Long id;
    private String boardName;
    private String boardType;
//    @Builder.Default // list를 디폴트 값으로 준다.
//    private List<Article> articles = new ArrayList<>();
}