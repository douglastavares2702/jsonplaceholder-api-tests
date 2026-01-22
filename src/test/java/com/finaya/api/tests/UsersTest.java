package com.finaya.api.tests;

import com.finaya.api.base.BaseTest;
import com.finaya.api.model.User;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class UsersTest extends BaseTest {

    @Test
    void deveRetornarListaDeUsuarios() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("$", hasSize(10))
                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("username", notNullValue())
                .body("email", notNullValue());
    }

    @Test
    void deveRetornarUsuarioUsandoPOJO() {

        User user = given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .extract()
                .as(User.class);

        assertEquals(1, user.getId());
        assertNotNull(user.getName());
        assertNotNull(user.getEmail());
        assertNotNull(user.getAddress());
        assertNotNull(user.getCompany());
    }

    @Test
    void deveRetornarUsarioComId1CamposCorretos() {
        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Leanne Graham"))
                .body("email", equalTo("Sincere@april.biz"))
                .body("address.zipcode", equalTo("92998-3874"));
        }
}
