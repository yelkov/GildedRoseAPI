package edu.badpals.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Item {
    @Id
    public Long id;

    @Column(name="name_item")
    public String name = "";

    @Column(name="sellin")
    public int sellIn = 0;

    @Column(name="quality")
    public int quality = 0;

    public Item(){}

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
