package org.lvy.avocado.server.resources;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;

public class ArticleResourceTest {

    private Client client;
    private WebTarget target;

    @Before
    public void init() {
        client = ClientBuilder.newClient();
        setTarget(client.target("http://localhost:9999/avocado-web/").path("rs/"));
    }

    @Test
    public void testGetArticle() {

    }

    @Test
    public void testAddArticle() {
        // fail("Not yet implemented");
        Form form = new Form();
        form.param("title", "test title");
        form.param("content", "test content");
        form.param("author", "12");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        form.param("createTime", dateFormat.format(new Date()));
        String result = getTarget().path("article").path("add").
                request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON).
                post(Entity.form(form), String.class);
        System.out.println(result);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public WebTarget getTarget() {
        return target;
    }

    public void setTarget(WebTarget target) {
        this.target = target;
    }

}
