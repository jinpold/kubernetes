package com.james.api.board;
import com.james.api.article.Article;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String registerDate;

    @Builder.Default
    private List<Article> articles = new ArrayList<>();

}