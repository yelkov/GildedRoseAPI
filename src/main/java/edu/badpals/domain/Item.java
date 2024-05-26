package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long id;

    @Column(name="name_item")
    public String name = "";

    @Column(name="sellIn")
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
