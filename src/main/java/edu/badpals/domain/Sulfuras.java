package edu.badpals.domain;

public class Sulfuras implements Updateable{
    private Item item;

    public Sulfuras(String name, int SellIn){
        this.item = new Item(name, SellIn, 80);
    }

    public String getName(){
        return this.item.name;
    }

    public int getSellIn(){
        return this.item.sellIn;
    }

    public int getQuality(){
        return this.item.quality;
    }

    public void setName(String newName){
        this.item.name = newName;
    }

    public void setQuality(int newQuality){
        //Esto nunca se modifica
    };

    public void setSellIn(int newSellIn){
        this.item.sellIn = newSellIn;
    }

    @Override
    public void updateQuality() {
        //Esto nunca se modifica
    }

    @Override
    public void updateSellIn(){
        //Esto nunca se modifica
    }
    @Override
    public String toString() {
        return this.item.toString();
    }
}
