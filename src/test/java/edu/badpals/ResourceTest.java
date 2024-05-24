package edu.badpals;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ResourceTest {
    @Inject
    EntityManager em;

    @Inject
    ResourceGildedRose resources;

    @Test
    public void test_injeccion() {
        Assertions.assertThat(resources.service).isNotNull();
    }

    @Test
    public void test_bienvenida() {
        given()
                .contentType(ContentType.TEXT)
                .when()
                .get("/bienvenida")
                .then()
                .statusCode(200)
                .body(is("¡Bienvenido a nuestra tienda!"));
    }

    @Test
    public void test_get_Item() {

        given()
                .pathParam("id", 1L)
                .when()
                .get("/item/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1),
                        "name", equalTo("+5 Dexterity Vest"),
                        "sellIn",equalTo(20),
                        "quality",equalTo(10));

        given()
                .pathParam("id", 30L)
                .when()
                .get("/item/{id}")
                .then()
                .statusCode(404);
    }


}