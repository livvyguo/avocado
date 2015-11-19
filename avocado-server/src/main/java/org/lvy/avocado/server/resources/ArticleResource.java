package org.lvy.avocado.server.resources;

import org.lvy.avocado.domain.Article;
import org.lvy.avocado.server.service.ArticleService;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by livvy (livvyguo@gmail.com) on 15/11/17.
 */
@Component
@Path("article")
public class ArticleResource {

    @Inject
    private ArticleService articleService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Article getArticle(@PathParam("id") Integer id) {
        Article article = getArticleService().getArticle(id);
        return article;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addArticle(@BeanParam Article article) {
        getArticleService().saveArticle(article);
        return Response.ok("ok").build();
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
