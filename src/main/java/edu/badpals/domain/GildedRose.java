package edu.badpals.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class GildedRose {
    List<Updateable> items = new ArrayList<>();

    private List<Updateable> getItems() {
        return items;
    }

    public GildedRose() {
    }

    public void addItem(Updateable item){
        getItems().add(item);
    }

    public int getSize(){
        return getItems().size();
    }

    Updateable getItem(int position){
        return getItems().get(position);
    }

    public void updateItems(){
        for (Updateable item : getItems()){
            item.updateItem();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Updateable item : getItems()){
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }


}
