package edu.badpals;

import edu.badpals.domain.*;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

@QuarkusTest
public class ServiceTest {

    @PersistenceContext
    EntityManager em;

    @Inject
    ServiceGildedRose servicio;

    @Test
    public void test_mapping_item(){
        Item queso = em.find(Item.class,2L);
        Assertions.assertThat(queso).isNotNull();
        Assertions.assertThat(queso.name).isEqualTo("Aged Brie");
        Assertions.assertThat(queso.quality).isEqualTo(2);
        Assertions.assertThat(queso.sellIn).isEqualTo(0);

    }

    @Test
    public void test_mapping_agedBrie(){
        AgedBrie queso = em.find(AgedBrie.class,2L);
        Assertions.assertThat(queso).isNotNull();
        Assertions.assertThat(queso.getName()).isEqualTo("Aged Brie");
        Assertions.assertThat(queso.getQuality()).isEqualTo(2);
        Assertions.assertThat(queso.getSellIn()).isEqualTo(0);
    }

    @Test
    public void test_mapping_normalItem(){
        NormalItem elixir = em.find(NormalItem.class,3L);
        Assertions.assertThat(elixir).isNotNull();
        Assertions.assertThat(elixir.getName()).isEqualTo("Elixir of the Mongoose");
        Assertions.assertThat(elixir.getQuality()).isEqualTo(5);
        Assertions.assertThat(elixir.getSellIn()).isEqualTo(7);
    }

    @Test
    public void test_mapping_conjured(){
        Conjured conjured = em.find(Conjured.class,9L);
        Assertions.assertThat(conjured).isNotNull();
        Assertions.assertThat(conjured.getName()).isEqualTo("Conjured Mana Cake");
        Assertions.assertThat(conjured.getQuality()).isEqualTo(3);
        Assertions.assertThat(conjured.getSellIn()).isEqualTo(6);
    }

    @Test
    public void test_mapping_backstagepass(){
        BackstagePass backstage = em.find(BackstagePass.class,7L);
        Assertions.assertThat(backstage).isNotNull();
        Assertions.assertThat(backstage.getName()).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        Assertions.assertThat(backstage.getQuality()).isEqualTo(49);
        Assertions.assertThat(backstage.getSellIn()).isEqualTo(10);
    }

    @Test
    public void test_mapping_sulfuras(){
        Sulfuras sulfuras = em.find(Sulfuras.class,4L);
        Assertions.assertThat(sulfuras).isNotNull();
        Assertions.assertThat(sulfuras.getName()).isEqualTo("Sulfuras, Hand of Ragnaros");
        Assertions.assertThat(sulfuras.getQuality()).isEqualTo(80);
        Assertions.assertThat(sulfuras.getSellIn()).isEqualTo(0);
    }

    @Test
    public void test_inyeccion_servicio() {
        Assertions.assertThat(servicio).isNotNull();
    }

    @Test
    public void test_carga_normalItem() {
        Assertions.assertThat(servicio).isNotNull();
        NormalItem elixir = servicio.cargaNormalItem(3L);
        Assertions.assertThat(elixir).isNotNull();
        Assertions.assertThat(elixir.getName()).isEqualTo("Elixir of the Mongoose");
        Assertions.assertThat(elixir.getSellIn()).isEqualTo(7);
        Assertions.assertThat(elixir.getQuality()).isEqualTo(5);
    }

    @Test
    public void test_carga_item_no_existe() {
        Assertions.assertThat(servicio).isNotNull();
        NormalItem otro = servicio.cargaNormalItem(25L);
        Assertions.assertThat(otro).isNotNull();
        Assertions.assertThat(otro.getName()).isEmpty();
        Assertions.assertThat(otro.getSellIn()).isZero();
        Assertions.assertThat(otro.getQuality()).isZero();
    }

}
