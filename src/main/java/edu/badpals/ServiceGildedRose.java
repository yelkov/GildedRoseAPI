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
        for (Updateable item : updateablesList){
            shop.addItem(item);
        }
        shop.updateItems();
    }
}
