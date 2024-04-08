package com.james.api.article.service;
import com.james.api.article.model.Article;
import com.james.api.article.model.ArticleDto;
import com.james.api.common.component.Messenger;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;

import java.util.*;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto) {

        return Article.builder().build();

    }

    default ArticleDto entityToDto(Article article) {

        return ArticleDto.builder().build();
    }
}
