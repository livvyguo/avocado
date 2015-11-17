package org.lvy.avocado.server.service;

import org.apache.ibatis.session.SqlSession;
import org.lvy.avocado.domain.Article;
import org.lvy.avocado.server.persistence.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by livvy (livvyguo@gmail.com) on 15/11/17.
 */
@Service
public class ArticleService {

    @Autowired
    @Qualifier("articleMapper")
    private ArticleMapper articleMapper;

    public ArticleMapper getArticleMapper() {
        return articleMapper;
    }

    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }


    public Article getArticle(Integer id) {
        return getArticleMapper().getArticle(id);
    }
}
