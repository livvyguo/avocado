package org.lvy.avocado.server.provider;

import org.lvy.avocado.domain.Article;
import org.lvy.avocado.server.service.ArticleService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by livvy (livvyguo@gmail.com) on 15/11/17.
 */
@Component
@Path("article")
public class ArticleResource {

    @Autowired
    private ArticleService articleService;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle(@PathParam("id") Integer id) {
        Article article = getArticleService().getArticle(id);
        return article;
    }


    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
