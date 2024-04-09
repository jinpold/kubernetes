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

        return Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }
    default ArticleDto entityToDto(Article ent) {

        return ArticleDto.builder()
                .id(ent.getId())
                .title(ent.getTitle())
                .content(ent.getContent())
                .regDate(ent.getRegDate().toString())
                .modDate(ent.getModDate().toString())
                .build();
    }
}
