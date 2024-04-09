package com.james.api.user.model;
import com.james.api.article.model.Article;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component // = Object와 유사하게 다 줄 수 있는 것. 제일 범위가 크다.
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;
//    @Builder.Default // List를 Default값으로 주는 것.
    private List<Article> articles  = new ArrayList<>();
}