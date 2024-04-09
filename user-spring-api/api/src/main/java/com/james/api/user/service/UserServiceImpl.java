package com.james.api.user.service;
import com.james.api.common.component.Messenger;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;
import com.james.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Messenger save(UserDto t) {
        repository.save(dtoToEntity(t));
        return Messenger.builder()
                .message("회원가입 성공"+t.getName())
                .build();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return existsById(id) ?
                Messenger.builder()
                        .message("회원탈퇴 완료")
                        .build() :
                Messenger.builder()
                        .message("회원탈퇴 실패")
                        .build();
    }

    @Override
    public Messenger modify(UserDto user) {
        return null;
    }
    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(long id) {
        // Optional.of(entityToDto(repository.findById(id)));
        return null;
    }
    @Override
    public long count() {
        return repository.count();
    }
    @Override
    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        return null;
    }

    @Override
    public List<UserDto> findUsersByName(String name) {
        return null;
    }

    @Override
    public Messenger login(UserDto param) {
        return null;
    }

    @Override
    public Optional<UserDto> findUserByUsername(String username) {
        User user = repository.findByUsername(username);
        return Optional.of(entityToDto(user));
    }
}