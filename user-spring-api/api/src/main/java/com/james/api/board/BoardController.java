package com.james.api.board;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.james.api.board.model.BoardDto;
import com.james.api.board.service.BoardServiceImpl;
import com.james.api.common.component.Messenger;
import com.james.api.common.component.PageRequestVo;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping(path = "/api/boards")
@Slf4j
public class BoardController {

    private final BoardServiceImpl service;


    @SuppressWarnings("static-access")
    @PostMapping( "/save")
    public ResponseEntity<Messenger> save(@RequestBody BoardDto dto) {
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(service.save(dto));

    }

    @GetMapping("/list") //all-users
    public ResponseEntity<List<BoardDto>> findAll() throws SQLException {
        log.info("입력받은 정보 : {}" );
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<BoardDto>> findById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id) {
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