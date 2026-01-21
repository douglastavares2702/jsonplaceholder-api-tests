package com.finaya.api.tests;

import com.finaya.api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsTest extends BaseTest {

    @Test
    void shouldReturnListOfPosts() {

        given()
        .when()
            .get("/posts")
        .then()
            .statusCode(200)
            .body("$", hasSize(100))
            .body("[0].userId", notNullValue())
            .body("[0].id", notNullValue())
            .body("[0].title", notNullValue())
            .body("[0].body", notNullValue());
    }

    @Test
    void shouldReturnPostById() {

        given()
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", notNullValue())
            .body("title", notNullValue());
    }
}
