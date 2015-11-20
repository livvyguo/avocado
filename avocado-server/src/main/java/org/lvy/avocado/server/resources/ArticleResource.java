package org.lvy.avocado.server.resources;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import org.lvy.avocado.domain.Article;
import org.lvy.avocado.server.service.ArticleService;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


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

    @GET
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Article> selectArticle(@QueryParam("page") @DefaultValue("1") Integer page,@QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        Article example = new Article();
        PageBounds pageBounds = new PageBounds();
        pageBounds.setPage(page);
        pageBounds.setLimit(pageSize);
        pageBounds.setContainsTotalCount(true);
        pageBounds.setAsyncTotalCount(true);
        PageList<Article> article = (PageList<Article>) getArticleService().getArticles(example,pageBounds);
        Paginator paginator =
                article.getPaginator();
        System.out.println(paginator);
        return article;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addArticle(@BeanParam Article article) {
        Integer result = getArticleService().saveArticle(article);
        if (result > 0) {
            return Response.ok("ok").build();
        }
        return Response.ok("error").build();
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
