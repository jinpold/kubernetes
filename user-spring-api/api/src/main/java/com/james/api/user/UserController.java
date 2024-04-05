package com.james.api.user;
import com.james.api.common.component.MessengerVo;
import com.james.api.common.component.PageRequestVo;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;
import com.james.api.user.repository.UserRepository;
import com.james.api.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;
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
    private final UserServiceImpl service;
    private final UserRepository repo;

    // ---------------------------------Command---------------------------------------

    @PostMapping(path = "/join")
    public ResponseEntity<MessengerVo> save(@RequestBody UserDto param) {
        log.info("입력받은 정보 : { }" + param);
        service.save(param);
        // User newUser = service.save(param);
        return ResponseEntity.ok
                (MessengerVo.builder()
                        .message("Success")
                        .code("200")
                        .build());

        //        Map<String, MessengerVo> map = new HashMap<>();
//        User newUser = repository.save(User.builder()
//                .username((String) paramMap.get("username"))
//                .password((String) paramMap.get("password"))
//                .name((String) paramMap.get("name"))
//                .phone((String) paramMap.get("phone"))
//                .job((String) paramMap.get("job"))
//                .build());
//        System.out.println("DB에 저장된 User 정보: " + newUser);
//        return map;
    }
    // -----------------------------------Query ---------------------------------------

    @PostMapping(path = "/login")
    public ResponseEntity<MessengerVo> login(@RequestBody Map<String, UserDto> paramap) {
        Map<String, MessengerVo> response = new HashMap<>();
        String username = String.valueOf(paramap.get("username"));
        //User user = service.findByUsername(username).orElse(null);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<UserDto>> findAll (Pageable pageable) throws SQLException {
        List<UserDto> ls = new ArrayList<>();
        service.findAll();
        return ResponseEntity.ok(new ArrayList<UserDto>());
    }
    @GetMapping("/findById/{id}") //api/all-users
    public ResponseEntity<Optional<UserDto>> findById(@PathVariable long id){
        Map<String, String> response = new HashMap<>();
        return ResponseEntity.ok(Optional.of(new UserDto()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessengerVo> deleteById(PageRequestVo vo){
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/updatePassword")
    public ResponseEntity<MessengerVo> updatePassword(PageRequestVo vo) {
        service.updatePassword(null);
        return ResponseEntity.ok(new MessengerVo());
    }

//    @GetMapping("/findById")
//    public ResponseEntity<MessengerVo> findById(PageRequestVo vo) throws  SQLException {
//        service.findById(0L);
//        return ResponseEntity.ok(new MessengerVo());
//    }

    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count(PageRequestVo vo) throws  SQLException {
        service.count();
        return ResponseEntity.ok(new MessengerVo());
    }



    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(PageRequestVo vo){
        service.existsById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/findUserByName")
    public ResponseEntity<MessengerVo> findUserByName(PageRequestVo vo) {
        service.findUsersByName(null);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/findUserByJob")
    public ResponseEntity<MessengerVo> findUserByJob(PageRequestVo vo) {
        service.findUsersByJob(null);
        return ResponseEntity.ok(new MessengerVo());
    }

}
