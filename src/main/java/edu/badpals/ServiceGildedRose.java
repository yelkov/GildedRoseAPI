package edu.badpals;

import edu.badpals.domain.AgedBrie;
import edu.badpals.domain.BackstagePass;
import edu.badpals.domain.NormalItem;
import edu.badpals.domain.Sulfuras;
import edu.badpals.repository.*;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.resteasy.annotations.LinkHeaderParam;

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

    public <T> T cargarItem(PanacheRepository<T> repository, Long id, T itemType){
        Optional<T> item = repository.findByIdOptional(id);
        return item.isPresent()?
                item.get():
                itemType;

    }

    public NormalItem cargaNormalItem(long id) {
        return cargarItem(normalItemRepository, id, new NormalItem());
    }

    public AgedBrie cargaAgedBrie(long id) {
        return cargarItem(agedBrieRepository, id, new AgedBrie());
    }
}
