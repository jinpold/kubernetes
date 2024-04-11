package com.james.api.user;
import com.james.api.article.model.ArticleDto;
import com.james.api.common.component.Messenger;
import com.james.api.common.component.PageRequestVo;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;
import com.james.api.user.repository.UserRepository;
import com.james.api.user.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping(path = "/api/users")
@Slf4j
public class UserController {
    private final UserService service;
    private final UserRepository repo;

    // ---------------------------------Command---------------------------------------
    @SuppressWarnings("static-access")
    @PostMapping( "/save")
    public ResponseEntity<Messenger> save(@RequestBody UserDto dto) {
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(service.save(dto));

    }
    // -----------------------------------Query ---------------------------------------

//    @PostMapping(path = "/login")
//    public ResponseEntity<MessengerVo> login(@RequestBody Map<String, UserDto> paramap) {
//        Map<String, MessengerVo> response = new HashMap<>();
//        String username = String.valueOf(paramap.get("username"));
//        //User user = service.findByUsername(username).orElse(null);
//        return ResponseEntity.ok(new MessengerVo());
//    }

    @PostMapping(path = "/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto param) {
         return ResponseEntity.ok(service.login(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll() throws SQLException {
        log.info("입력받은 정보 : {}");
        System.out.println(service.findAll());
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/detail")
    public ResponseEntity<UserDto> findById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id).orElseGet(UserDto::new));
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

    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody UserDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.modify(param));
    }

    @PostMapping("/search")
    public ResponseEntity<Optional<UserDto>> findUsersByName(@RequestBody UserDto param) {
        //log.info("입력받은 정보 : {}", name );
        return ResponseEntity.ok(service.findUserByUsername(param.getName()));
    }
    @GetMapping("/findUserByJob")
    public ResponseEntity<Messenger> findUserByJob(PageRequestVo vo) {
        service.findUsersByJob(null);
        return ResponseEntity.ok(new Messenger());
    }
}
