package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name="normalitems")
public class NormalItem implements Updateable{
    @Id
    @OneToOne
    @JoinColumn(name="item")
    private Item item;

    public NormalItem(){}

    public NormalItem(String name, int SellIn, int Quality){
        this.item = new Item(name, SellIn, Quality);
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

    public void setSellIn(int newSellIn){
        this.item.sellIn = newSellIn;
    }

    public void setQuality(int newQuality){
        this.item.quality = newQuality;
    }

    @Override
    public void updateQuality() {
        if(getSellIn() >= 0){
            setQuality(getQuality() - 1);
        } else {
            setQuality(getQuality() - 2);
        }

        correctQuality();

    }

    @Override
    public String toString() {
        return this.item.toString();
    }

}
