package com.james.api.board;

import com.james.api.common.component.MessengerVo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BoardServiceImpl implements BoardService {
    @Override
    public MessengerVo save(Object o) {
        return null;
    }

    @Override
    public String insertMany() {
        return null;
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional findById(long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }
}

