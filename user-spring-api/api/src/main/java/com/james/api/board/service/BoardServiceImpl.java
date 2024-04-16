package com.james.api.board.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.james.api.common.component.Messenger;
import jakarta.transaction.Transactional;
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
        repository.save(dtoToEntity(t));
        return Messenger.builder()
                .message("성공")
                .status(200)
                .build();
    }
    @Override
    public List<BoardDto> findAll() throws SQLException {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }
    @Override
    public Optional<BoardDto> findById(Long id) {
        return repository.findById(id).stream().map(i -> entityToDto(i)).findAny();
    }

    @Transactional
    @Override
    public Messenger modify(BoardDto boardDto) {
        repository.save(dtoToEntity(boardDto));
        return Messenger.builder()
                .message("성공")
                .status(200)
                .build();
    }
    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return existsById(id) ?
                Messenger.builder()
                        .message("회원탈퇴 완료")
                        .status(200)
                        .build() :
                Messenger.builder()
                        .message("회원탈퇴 실패")
                        .status(200)
                        .build();
    }


    @Override
    public Long count() {
        return repository.count();
    }
    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}