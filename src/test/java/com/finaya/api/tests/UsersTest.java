package com.finaya.api.tests;

import com.finaya.api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
