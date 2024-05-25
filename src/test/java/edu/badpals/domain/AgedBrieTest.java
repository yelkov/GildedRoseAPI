package edu.badpals.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieTest {

        @Test
        public void AgedBrieGetters(){
            AgedBrie item = new AgedBrie("Queso", 100, 50);
            assertEquals("Queso", item.getName());
            assertEquals(100, item.getSellIn());
            assertEquals(50, item.getQuality());
        }

        @Test
        public void AgedBrieSetters(){
            AgedBrie item = new AgedBrie("Queso", 80, 20);
            item.setName("Queso azul");
            item.setSellIn(100);
            item.setQuality(50);
            assertEquals("Queso azul", item.getName());
            assertEquals(100, item.getSellIn());
            assertEquals(50, item.getQuality());
        }

        @Test
        public void AgedBrie_UpdateSellIn(){
            AgedBrie item = new AgedBrie("Queso", 80, 20);
            item.updateSellIn();
            assertEquals(79, item.getSellIn());

        }

        @Test
        public void AgedBrie_updateQuality_notExpired(){
            AgedBrie item = new AgedBrie("Queso",80,20);
            item.updateQuality();
            assertEquals(21,item.getQuality());
        }
        @Test
        public void AgedBrie_updateQuality_Expired(){
            AgedBrie item = new AgedBrie("Queso",-3,20);
            item.updateQuality();
            assertEquals(22,item.getQuality());
    }
    @Test
    public void AgedBrie_updateQuality_aboutToExpire(){
        AgedBrie item = new AgedBrie("Queso",0,20);
        item.updateQuality();
        assertEquals(21,item.getQuality());
    }

    @Test
    public void AgedBrie_UpdateQuality_50QualityNotExpired(){
        AgedBrie item = new AgedBrie("Queso", 4, 50);
        item.updateQuality();
        assertEquals(50,item.getQuality());
    }
    @Test
    public void AgedBrie_UpdateQuality_50QualityExpired(){
        AgedBrie item = new AgedBrie("Queso", -4, 50);
        item.updateQuality();
        assertEquals(50,item.getQuality());
    }
    @Test
    public void AgedBrie_UpdateQuality_49QualityExpired(){
        AgedBrie item = new AgedBrie("Queso", -4, 49);
        item.updateQuality();
        assertEquals(50,item.getQuality());
    }
    @Test
    public void AgedBrie_UpdateItem_NotExpired(){
        AgedBrie item = new AgedBrie("Queso", 10, 20);
        item.updateItem();
        assertEquals(9, item.getSellIn());
        assertEquals(21,item.getQuality());
    }
    @Test
    public void AgedBrie_UpdateItem_AboutToExpired(){
        AgedBrie item = new AgedBrie("Queso", 1, 20);
        item.updateItem();
        assertEquals(0, item.getSellIn());
        assertEquals(21,item.getQuality());
    }
    @Test
    public void AgedBrie_UpdateItem_justExpired(){
        AgedBrie item = new AgedBrie("Queso", 0, 20);
        item.updateItem();
        assertEquals(-1, item.getSellIn());
        assertEquals(22,item.getQuality());
    }
    @Test
    public void AgedBrie_UpdateItem_Expired(){
        AgedBrie item = new AgedBrie("Queso", -5, 20);
        item.updateItem();
        assertEquals(-6, item.getSellIn());
        assertEquals(22,item.getQuality());
    }
}
