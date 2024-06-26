package com.james.api.article;
import com.james.api.article.model.ArticleDto;
import com.james.api.article.service.ArticleServiceImpl;
import com.james.api.board.model.BoardDto;
import com.james.api.common.component.Messenger;
import com.james.api.common.component.PageRequestVo;
import com.james.api.user.model.UserDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*") // 기존에 origins = http://localhost:3000 이던걸 보안 걸었음. 퍼사드 패턴
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping(path = "/api/articles")
@Slf4j
public class ArticleController {
    private final ArticleServiceImpl service;

    @SuppressWarnings("static-access")
    @PostMapping( "/save")
    public ResponseEntity<Messenger> save(@RequestBody ArticleDto dto) {
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(service.save(dto));

    }
    @GetMapping("/list")
    public ResponseEntity<List<ArticleDto>> findAll() throws SQLException {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<ArticleDto> findById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id).orElseGet(ArticleDto::new));
    }
    @PutMapping ("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody ArticleDto dto) {
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(service.modify(dto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Messenger> deleteById(@PathVariable Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count()  {
        return ResponseEntity.ok(service.count());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Messenger> existsById(PageRequestVo vo){
        service.existsById(0L);
        return ResponseEntity.ok(new Messenger());
    }
}
