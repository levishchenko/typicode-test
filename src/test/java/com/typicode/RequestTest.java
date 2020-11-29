package com.typicode;

import com.typicode.conditions.Conditions;
import com.typicode.dto.Post;
import com.typicode.services.PostApiService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Every.everyItem;

import io.restassured.RestAssured;

public class RequestTest {

    PostApiService apiService = new PostApiService();

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @Test
    public void verifyPostMethod() {
        Post post = new Post().title("test title").body("test body").userId(100);

        apiService.sendPostRequest(post)
                .shouldHave(Conditions.statusCode(201))
                .shouldHave(Conditions.bodyField("id", not(is(emptyOrNullString()))));
    }

    @Test
    public void verifyPutMethod() {
        Post post = new Post().title("test title");

        apiService.sendPutRequest(post, 100)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("id", is(100)))
                .shouldHave(Conditions.bodyField("title", is("test title")));
    }

    @Test
    public void verifyPatchMethod() {
        Post post = new Post().body("test body");

        apiService.sendPatchRequest(post, 100)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("id", is(100)))
                .shouldHave(Conditions.bodyField("body", is("test body")));
    }

    @Test
    public void verifyDeleteMethod() {
        apiService.sendDeleteRequest(100).shouldHave(Conditions.statusCode(200));
    }

    @Test
    public void verifyGetMethod() {
        apiService.sendGetRequest()
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("", hasSize(100)));
    }

    @Test
    public void verifyGetByIdMethod() {
        apiService.sendGetRequestById(1)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("id", is(1)));

    }

    @Test
    public void verifyGetCommentMethodById() {
        apiService.sendGetRequestToComments(3)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("postId", everyItem(is(3))));

    }
}
