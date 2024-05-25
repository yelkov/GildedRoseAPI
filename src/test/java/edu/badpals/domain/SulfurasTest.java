package edu.badpals.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SulfurasTest {
    @Test
    public void SulfurasGetters(){
        Sulfuras item = new Sulfuras("Sulfuras", 100);
        assertEquals("Sulfuras", item.getName());
        assertEquals(100, item.getSellIn());
        assertEquals(80, item.getQuality());
    }

    @Test
    public void SulfurasSetters(){
        Sulfuras item = new Sulfuras("Sulfuras", 100);
        item.setName("New Sulfuras");
        item.setSellIn(80);
        assertEquals("New Sulfuras", item.getName());
        assertEquals(80, item.getSellIn());
    }

    @Test
    public void Sulfuras_UpdateSellIn(){
        Sulfuras item = new Sulfuras("Sulfuras", 100);
        item.updateSellIn();
        assertEquals(100, item.getSellIn());

    }

    @Test
    public void Sulfuras_UpdateQuality(){
        Sulfuras item = new Sulfuras("Sulfuras", 100);
        item.updateQuality();
        assertEquals(80, item.getQuality());
    }

    @Test
    public void Sulfuras_UpdateItem(){
        Sulfuras item = new Sulfuras("Sulfuras", 100);
        item.updateItem();
        assertEquals(100, item.getSellIn());
        assertEquals(80, item.getQuality());
    }
}
