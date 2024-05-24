package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name="agedbrie")
public class AgedBrie implements Updateable{

    @Id
    @OneToOne
    @JoinColumn(name="item")
    private Item item;

    public AgedBrie(){}

    public AgedBrie(String name, int sellIn, int quality){
        this.item = new Item( name, sellIn, quality);
    }


    public String getName() {
        return item.name;
    }

    public int getQuality() {
        return item.quality;
    }

    @Override
    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public void setSellIn(int newSellIn) {
        this.item.sellIn = newSellIn;
    }

    public void setName(String newName) {
        this.item.name = newName;
    }
    public void setQuality(int newQuality) {
        this.item.quality = newQuality;
    }

    @Override
    public void updateQuality() {
        if(getSellIn()>=0){
            setQuality(getQuality()+1);
        }else{
            setQuality(getQuality()+2);
        }
        correctQuality();
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
