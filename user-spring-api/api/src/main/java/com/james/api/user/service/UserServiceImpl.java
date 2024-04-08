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
        entityToDto((repository.save(dtoToEntity(t))));
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(UserDto user) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        repository.findAll();
        return new ArrayList<>();
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
    public Optional<User> findUsersByName(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        return null;
    }
    @Override
    public Messenger login(UserDto param) {
        return null;
    }
}