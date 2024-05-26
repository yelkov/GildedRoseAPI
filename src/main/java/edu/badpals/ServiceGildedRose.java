package edu.badpals;

import edu.badpals.domain.*;
import edu.badpals.repository.*;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServiceGildedRose {
    @Inject
    ItemRepository itemRepository;
    @Inject
    NormalItemRepository normalItemRepository;
    @Inject
    AgedBrieRepository agedBrieRepository;
    @Inject
    BackstagepassRepository backstagepassRepository;
    @Inject
    SulfurasRepository sulfurasRepository;
    @Inject
    ConjuredRepository conjuredRepository;
    @Inject
    GildedRose shop;

    private <T> T cargarItem(PanacheRepository<T> repository, Long id, T itemType){
        Optional<T> item = repository.findByIdOptional(id);
        return item.isPresent()?
                item.get():
                itemType;

    }
    public Item cargarItem(Long id){
        return cargarItem(itemRepository, id, new Item());
    }

    public NormalItem cargaNormalItem(long id) {
        return cargarItem(normalItemRepository, id, new NormalItem());
    }

    public AgedBrie cargaAgedBrie(long id) {
        return cargarItem(agedBrieRepository, id, new AgedBrie());
    }

    public Conjured cargaConjured(long id) {
        return cargarItem(conjuredRepository, id, new Conjured());
    }

    public BackstagePass cargaBackstagePass(long id) {
        return cargarItem(backstagepassRepository, id, new BackstagePass());
    }

    public Sulfuras cargaSulfuras(long id) {
        return cargarItem(sulfurasRepository, id, new Sulfuras());
    }

    public List<Item> cargaAllItems() {
        return itemRepository.listAll();
    }

    public List<NormalItem> cargaAllNormalItems(){
        return normalItemRepository.listAll();
    }

    public List<AgedBrie> cargaAllAgedBrie(){
        return agedBrieRepository.listAll();
    }

    public List<BackstagePass> cargaAllBackstagePass(){
        return backstagepassRepository.listAll();
    }

    public List<Conjured> cargaAllConjured(){
        return conjuredRepository.listAll();
    }

    public List<Sulfuras> cargaAllSulfuras(){
        return sulfurasRepository.listAll();
    }

    public List<Updateable> cargarAllUpdateables(){
        List<Updateable> updateables = new ArrayList<>();
        updateables.addAll(cargaAllNormalItems());
        updateables.addAll(cargaAllAgedBrie());
        updateables.addAll(cargaAllBackstagePass());
        updateables.addAll(cargaAllSulfuras());
        updateables.addAll(cargaAllConjured());
        return updateables;
    }

    @Transactional
    public void updateDatabase() {
        List<Updateable> updateablesList = cargarAllUpdateables();
        if(shop.isEmpty()) {
            for (Updateable item : updateablesList) {
                shop.addItem(item);
            }
        }
        shop.updateItems();
    }

    @Transactional
    public Item crearItem(String name, Integer sellIn, Integer quality){
        Item item = new Item(name,sellIn,quality);
        itemRepository.persist(item);
        return item;
    }

    @Transactional
    public boolean borrarItem(Long id){
        Optional<Item> item = itemRepository.findByIdOptional(id);
        if (item.isPresent()){
            itemRepository.delete(item.get());
            return true;
        }else{
            return false;
        }

    }

    /*@Transactional
    public NormalItem crearNormalItem(String name, Integer sellIn, Integer quality){
        NormalItem normalItem = new NormalItem(name,sellIn,quality);

        return normalItem;
    }*/

    /*@Transactional
    public <T> T crearItem(String name,Integer sellIn, Integer quality, String tipo){
        switch (tipo){
            case "NormalItem":
                NormalItem normalItem = new NormalItem(name,sellIn,quality);
                normalItemRepository.persist(normalItem);
                return (T) normalItem;
            case "AgedBrie":
                AgedBrie agedBrie = new AgedBrie(name,sellIn,quality);
                agedBrieRepository.persist(agedBrie);
                return (T) agedBrie;
            case "Sulfuras":
                Sulfuras sulfuras = new Sulfuras(name,sellIn);
                sulfurasRepository.persist(sulfuras);
                return (T) sulfuras;
            case "Conjured":
                Conjured conjured = new Conjured(name,sellIn,quality);
                conjuredRepository.persist(conjured);
                return (T) conjured;
            case "BackstagePass":
                BackstagePass backstagePass = new BackstagePass(name,sellIn,quality);
                backstagepassRepository.persist(backstagePass);
                return (T) backstagePass;
            default:
                return null;
        }
    }*/
}
