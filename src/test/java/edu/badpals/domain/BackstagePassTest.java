package edu.badpals.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassTest {
    @Test
    public void BackstagePassGetters(){
        BackstagePass item = new BackstagePass("Entrada", 100, 50);
        assertEquals("Entrada", item.getName());
        assertEquals(100, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    public void BackstagePassSetters(){
        BackstagePass item = new BackstagePass("Entrada", 80, 20);
        item.setName("Entrada azul");
        item.setSellIn(100);
        item.setQuality(50);
        assertEquals("Entrada azul", item.getName());
        assertEquals(100, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    public void BackstagePass_UpdateSellIn(){
        BackstagePass item = new BackstagePass("Entrada", 80, 20);
        item.updateSellIn();
        assertEquals(79, item.getSellIn());

    }

    @Test
    public void BackstagePass_updateQuality_bigger10(){
        BackstagePass item = new BackstagePass("Entrada",80,20);
        item.updateQuality();
        assertEquals(21,item.getQuality());
    }
    @Test
    public void BackstagePass_updateQuality_sellIn10(){
        BackstagePass item = new BackstagePass("Entrada",10,20);
        item.updateQuality();
        assertEquals(22,item.getQuality());
    }
    @Test
    public void BackstagePass_updateQuality_bigger5lower10(){
        BackstagePass item = new BackstagePass("Entrada",7,20);
        item.updateQuality();
        assertEquals(22,item.getQuality());
    }
    @Test
    public void BackstagePass_updateQuality_sellIn5(){
        BackstagePass item = new BackstagePass("Entrada",5,20);
        item.updateQuality();
        assertEquals(23,item.getQuality());
    }
    @Test
    public void BackstagePass_updateQuality_bigger0lower5(){
        BackstagePass item = new BackstagePass("Entrada",3,20);
        item.updateQuality();
        assertEquals(23,item.getQuality());
    }
    @Test
    public void BackstagePass_updateQuality_sellIn0(){
        BackstagePass item = new BackstagePass("Entrada",0,20);
        item.updateQuality();
        assertEquals(23,item.getQuality());
    }
    @Test
    public void BackstagePass_updateQuality_lower0(){
        BackstagePass item = new BackstagePass("Entrada",-5,20);
        item.updateQuality();
        assertEquals(0,item.getQuality());
    }

    @Test
    public void BackstagePass_UpdateQuality_48Qbigger0lower5(){
        BackstagePass item = new BackstagePass("Entrada", 3, 48);
        item.updateQuality();
        assertEquals(50,item.getQuality());
    }
    @Test
    public void BackstagePass_UpdateQuality_49Qbigger5lower10(){
        BackstagePass item = new BackstagePass("Queso", 7, 49);
        item.updateQuality();
        assertEquals(50,item.getQuality());
    }
    @Test
    public void BackstagePass_UpdateQuality_50bigger10(){
        BackstagePass item = new BackstagePass("Queso", 20, 50);
        item.updateQuality();
        assertEquals(50,item.getQuality());
    }
    @Test
    public void BackstagePass_UpdateItem_sellIn11Qplus1(){
        BackstagePass item = new BackstagePass("Entrada", 12, 20);
        item.updateItem();
        assertEquals(11, item.getSellIn());
        assertEquals(21,item.getQuality());
    }
    @Test
    public void BackstagePass_UpdateItem_sellIn10moreExpensive(){
        BackstagePass item = new BackstagePass("Entrada", 11, 20);
        item.updateItem();
        assertEquals(10, item.getSellIn());
        assertEquals(22,item.getQuality());
    }
    @Test
    public void BackstagePass_UpdateItem_sellIn6moreExpensive(){
        BackstagePass item = new BackstagePass("Entrada", 6, 20);
        item.updateItem();
        assertEquals(5, item.getSellIn());
        assertEquals(23,item.getQuality());
    }
    @Test
    public void BackstagePass_UpdateItem_sellIn1moreExpensive(){
        BackstagePass item = new BackstagePass("Entrada", 1, 20);
        item.updateItem();
        assertEquals(0, item.getSellIn());
        assertEquals(23,item.getQuality());
    }
    @Test
    public void BackstagePass_UpdateItem_sellIn0Q0(){
        BackstagePass item = new BackstagePass("Entrada", 0, 20);
        item.updateItem();
        assertEquals(-1, item.getSellIn());
        assertEquals(0,item.getQuality());
    }


}