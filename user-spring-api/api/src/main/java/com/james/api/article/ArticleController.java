package com.james.api.article;
import com.james.api.article.model.Article;
import com.james.api.article.service.ArticleServiceImpl;
import com.james.api.common.component.MessengerVo;
import com.james.api.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public ResponseEntity<MessengerVo> save(PageRequestVo vo) throws  SQLException {
        service.save(null);
        return ResponseEntity.ok(new MessengerVo());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(@PathVariable long id) throws  SQLException {
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo) throws  SQLException {
        service.findAll();
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessengerVo> findById(PageRequestVo vo) throws  SQLException {
        service.findById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count(PageRequestVo vo) throws  SQLException {
        service.count();
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(@PathVariable long id) throws  SQLException {
        service.existsById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
}
