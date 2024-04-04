package com.james.api.article;
import com.james.api.common.component.MessengerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*") // 기존에 origins = http://localhost:3000 이던걸 보안 걸었음. 퍼사드 패턴
@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleServiceImpl service;
    @SuppressWarnings("unchecked")
    @GetMapping("/api/all-articles")
    public Map<?, ?> findAll() throws SQLException {
        Map<String, Object> map = new HashMap<>();
//        map.put("message", MessengerVo.SUCCESS);
        List<Article> list = new ArrayList<>();


//        list.add(Article.builder()
//                .id(1L)
//                .title("제목")
//                .content("내용")
//                .writer("글쓴이")
//                .registerDate("240327")
//                .build());

        list = service.findAll();
        map.put("result", list);
        return map;
    }
}
