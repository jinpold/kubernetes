package com.james.api.board.service;
import com.james.api.board.model.BoardDto;
import com.james.api.board.repository.BoardRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BoardServiceImpl implements BoardService {

    private BoardRepository repo;

    @Override
    public BoardDto save(BoardDto t) {
        return entityToDto(Optional.of(repo.save(dtoToEntity(t))));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional findById(long id) {
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

