package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name="sulfuras")
public class Sulfuras implements Updateable{
    @Id
    @OneToOne
    @JoinColumn(name="item")
    private Item item;

    public Sulfuras(){
        this.item = new Item();
    }

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

    @Override
    public Item getItem(){
        return this.item;
    }
}
