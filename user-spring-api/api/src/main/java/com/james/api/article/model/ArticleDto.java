package com.james.api.article.model;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component // = Object와 느낌으로 다 줄 수 있는 것.
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private String registerDate;
    private Long writerId;
    private Long boradId;

}
