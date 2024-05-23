package edu.badpals.domain;

public interface Updateable {
    public int getSellIn();
    public void setSellIn(int newSellIn);
    public void setQuality(int newQuality);
    public int getQuality();
    public void updateQuality();

    public default void updateSellIn(){
        setSellIn(getSellIn() - 1);
    }

    public default void correctQuality(){
        if(getQuality() > 50){
            setQuality(50);
        }
        if(getQuality()<0){
            setQuality(0);
        }
    }
    
    public default void updateItem(){
        updateSellIn();
        updateQuality();
    }

}
