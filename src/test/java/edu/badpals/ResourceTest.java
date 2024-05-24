package edu.badpals;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
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


}