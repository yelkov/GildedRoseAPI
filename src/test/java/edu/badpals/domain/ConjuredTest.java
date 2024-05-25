package edu.badpals.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConjuredTest {
    @Test
    public void NormalItemGetters(){
        Conjured item = new Conjured("Conjured Rice", 100, 50);
        assertEquals("Conjured Rice", item.getName());
        assertEquals(100, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    public void NormalItemSetters(){
        Conjured item = new Conjured("Conjured flour", 80, 30);
        item.setName("Conjured Rice");
        item.setSellIn(100);
        item.setQuality(50);
        assertEquals("Conjured Rice", item.getName());
        assertEquals(100, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    public void NormalItem_UpdateSellIn(){
        Conjured item = new Conjured("Conjured flour", 80, 30);
        item.updateSellIn();
        assertEquals(79, item.getSellIn());

    }

    @Test
    public void NormalItem_UpdateQuality_NotExpired(){
        Conjured item = new Conjured("Conjured flour", 80, 30);
        item.updateQuality();
        assertEquals(28,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_AboutToExpired(){
        Conjured item = new Conjured("Conjured flour", 0, 30);
        item.updateQuality();
        assertEquals(28,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_Expired(){
        Conjured item = new Conjured("Conjured flour", -3, 30);
        item.updateQuality();
        assertEquals(26,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_NullQualityNotExpired(){
        Conjured item = new Conjured("Conjured flour", 80, 0);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_1QualityNotExpired(){
        Conjured item = new Conjured("Conjured flour", 80, 1);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_NullQualityExpired(){
        Conjured item = new Conjured("Conjured flour", -4, 0);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateQuality_1QualityExpired(){
        Conjured item = new Conjured("Conjured flour", -3, 3);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_NotExpired(){
        Conjured item = new Conjured("Conjured flour", 20, 30);
        item.updateItem();
        assertEquals(19, item.getSellIn());
        assertEquals(28,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_AbouttoExpire(){
        Conjured item = new Conjured("Conjured flour", 1, 30);
        item.updateItem();
        assertEquals(0, item.getSellIn());
        assertEquals(28,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_JustExpired(){
        Conjured item = new Conjured("Conjured flour", 0, 30);
        item.updateItem();
        assertEquals(-1, item.getSellIn());
        assertEquals(26,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_Expired(){
        Conjured item = new Conjured("Conjured flour", -4, 30);
        item.updateItem();
        assertEquals(-5, item.getSellIn());
        assertEquals(26,item.getQuality());
    }

    @Test
    public void NormalItem_UpdateItem_Expired_Quality(){
        Conjured item = new Conjured("Conjured flour", -4, 3);
        item.updateItem();
        assertEquals(-5, item.getSellIn());
        assertEquals(0,item.getQuality());
    }
}
