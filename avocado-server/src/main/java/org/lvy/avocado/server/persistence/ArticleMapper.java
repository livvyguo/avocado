package org.lvy.avocado.server.persistence;

import org.apache.ibatis.annotations.Param;
import org.lvy.avocado.common.annotation.Mapper;
import org.lvy.avocado.domain.Article;
import org.springframework.stereotype.Repository;

/**
 * Created by livvy (livvyguo@gmail.com) on 15/11/17.
 */
@Mapper
public interface ArticleMapper {

    public Article getArticle(@Param("id") Integer id);

    public void saveArticle(@Param("article") Article article);
}
