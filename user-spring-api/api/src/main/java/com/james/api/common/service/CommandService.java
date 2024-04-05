package com.james.api.common.service;

import com.james.api.article.model.ArticleDto;

public interface CommandService<T> {

    T save (T t);
    void deleteById (Long id);
}
