package com.james.api.board.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.james.api.common.component.Messenger;
import org.springframework.stereotype.Service;
import com.james.api.board.model.BoardDto;
import com.james.api.board.repository.BoardRepository;


import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    public Messenger save(BoardDto t) {
        entityToDto((repository.save(dtoToEntity(t))));
        return new Messenger();
    }
    @Override
    public Messenger deleteById(Long id) {
        return null;
    }
    @Override
    public Messenger modify(BoardDto boardDto) {
        return null;
    }
    @Override
    public List<BoardDto> findAll() throws SQLException {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }
    @Override
    public Optional<BoardDto> findById(long id) {
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
}