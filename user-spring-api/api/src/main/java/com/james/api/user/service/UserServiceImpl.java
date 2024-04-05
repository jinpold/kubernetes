package com.james.api.user.service;
import com.james.api.article.model.ArticleDto;
import com.james.api.common.component.PageRequestVo;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;
import com.james.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    @Override
    public UserDto save(UserDto t) {
        return entityToDto((repo.save(dtoToEntity(t))));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }
    @Override
    public String updatePassword(User user) {
        return null;
    }

    @Override
    public List<?> findUsersByName(String name) {
        return null;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return null;
    }


    @Override
    public List<UserDto> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional findById(long id) {
        return repo.findById(id);
    }
    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

}