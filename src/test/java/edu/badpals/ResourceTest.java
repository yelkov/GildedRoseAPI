package edu.badpals;

import edu.badpals.domain.Item;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
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
    @Test
    public void test_get_all_items() {
        given()
                .when()
                .get("/items")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", greaterThan(0))
                .body("id[0]", notNullValue())
                .body("name[0]", notNullValue())
                .body("sellIn[0]", notNullValue())
                .body("quality[0]", notNullValue());
    }

    @Test
    @Transactional
    public void test_post_item_ok() {

        given()
                .body("{\"name\": \"Snitch Dorada\", \"sellIn\":10,\"quality\":35}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/crearItem")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("name", equalTo("Snitch Dorada"),
                        "sellIn", equalTo(10),
                        "quality",equalTo(35));

        TypedQuery<Item> query = em.createQuery("select item from Item item where item.name = 'Snitch Dorada'",Item.class);
        Item item = query.getSingleResult();
        Assertions.assertThat(item).isNotNull();
        Assertions.assertThat(item.sellIn).isEqualTo(10);
        Assertions.assertThat(item.name).isEqualTo("Snitch Dorada");
        Assertions.assertThat(item.quality).isEqualTo(35);
        em.remove(item);

    }


}