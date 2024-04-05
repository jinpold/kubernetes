package com.james.api.article.service;
import com.james.api.article.model.ArticleDto;
import com.james.api.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private static ArticleRepository repo;

    @Override
    public ArticleDto save(ArticleDto t) {
        return entityToDto(Optional.of(repo.save(dtoToEntity(t))));
    }


    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }


    @Override
    public List<ArticleDto> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<ArticleDto> findById(long id) {
        return Optional.of(entityToDto(repo.findById(id)));
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