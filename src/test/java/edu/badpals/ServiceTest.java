package edu.badpals;

import edu.badpals.domain.AgedBrie;
import edu.badpals.domain.Item;
import edu.badpals.domain.NormalItem;
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
    ServiceGildedRose service;

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

    /*@Test
    public void test_mapping_normalItem(){
        NormalItem elixir = em.find(NormalItem.class,3L);
        Assertions.assertThat(elixir).isNotNull();
        Assertions.assertThat(elixir.getName()).isEqualTo("Elixir of the Mongoose");
        Assertions.assertThat(elixir.getQuality()).isEqualTo(5);
        Assertions.assertThat(elixir.getSellIn()).isEqualTo(7);
    }*/


}
