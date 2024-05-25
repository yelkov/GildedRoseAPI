package edu.badpals.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NormalItemTest {

    @Test
    public void NormalItemGetters(){
        NormalItem item = new NormalItem("Arroz", 100, 50);
        assertEquals("Arroz", item.getName());
        assertEquals(100, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    public void NormalItemSetters(){
        NormalItem item = new NormalItem("Harina", 80, 20);
        item.setName("Arroz");
        item.setSellIn(100);
        item.setQuality(50);
        assertEquals("Arroz", item.getName());
        assertEquals(100, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    public void NormalItem_UpdateSellIn(){
        NormalItem item = new NormalItem("Harina", 80, 20);
        item.updateSellIn();
        assertEquals(79, item.getSellIn());

    }

    @Test
    public void NormalItem_UpdateQuality_NotExpired(){
        NormalItem item = new NormalItem("Leche", 10, 20);
        item.updateQuality();
        assertEquals(19,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_AboutToExpired(){
        NormalItem item = new NormalItem("Leche", 0, 20);
        item.updateQuality();
        assertEquals(19,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_Expired(){
        NormalItem item = new NormalItem("Leche", -3, 20);
        item.updateQuality();
        assertEquals(18,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_NullQualityNotExpired(){
        NormalItem item = new NormalItem("Leche", 4, 0);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_NullQualityExpired(){
        NormalItem item = new NormalItem("Leche", -4, 0);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_1QualityExpired(){
        NormalItem item = new NormalItem("Leche", -4, 1);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_NotExpired(){
        NormalItem item = new NormalItem("Leche", 10, 20);
        item.updateItem();
        assertEquals(9, item.getSellIn());
        assertEquals(19,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_AbouttoExpire(){
        NormalItem item = new NormalItem("Leche", 1, 20);
        item.updateItem();
        assertEquals(0, item.getSellIn());
        assertEquals(19,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_JustExpired(){
        NormalItem item = new NormalItem("Leche", 0, 20);
        item.updateItem();
        assertEquals(-1, item.getSellIn());
        assertEquals(18,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_Expired(){
        NormalItem item = new NormalItem("Leche", -20, 10);
        item.updateItem();
        assertEquals(-21, item.getSellIn());
        assertEquals(8,item.getQuality());
    }
}
