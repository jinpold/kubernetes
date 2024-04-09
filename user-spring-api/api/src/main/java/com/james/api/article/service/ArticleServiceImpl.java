package com.james.api.article.service;
import com.james.api.article.model.ArticleDto;
import com.james.api.article.repository.ArticleRepository;
import com.james.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private static ArticleRepository repository;

    @Override
    public Messenger save(ArticleDto t) {
        entityToDto((repository.save(dtoToEntity(t))));
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(ArticleDto articleDto) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() throws SQLException {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<ArticleDto> findById(long id) {
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
}

