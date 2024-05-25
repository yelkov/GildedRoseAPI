package edu.badpals.domain;

import edu.badpals.repository.ItemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GildedRose {

    @Inject
    EntityManager em;

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

    @Transactional
    public void updateItems(){
        for (Updateable updateable : getItems()){
            updateable.updateItem();
            em.merge(updateable.getItem());
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


    public boolean isEmpty() {
        return items.isEmpty();
    }
}
