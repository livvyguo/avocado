package org.lvy.avocado.server.persistence;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.Param;
import org.lvy.avocado.common.annotation.Mapper;
import org.lvy.avocado.domain.Article;

import java.util.List;

/**
 * Created by livvy (livvyguo@gmail.com) on 15/11/17.
 */
@Mapper
public interface ArticleMapper {

    public Article getArticle(@Param("id") Integer id);

    public Integer saveArticle(@Param("article") Article article);

    public List<Article> getArticles(@Param("article") Article article, PageBounds pageBounds);
}
