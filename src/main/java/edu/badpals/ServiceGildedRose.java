package edu.badpals;

import edu.badpals.domain.AgedBrie;
import edu.badpals.domain.BackstagePass;
import edu.badpals.domain.NormalItem;
import edu.badpals.domain.Sulfuras;
import edu.badpals.repository.*;
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

    public NormalItem cargaNormalItem(long id) {
        Optional<NormalItem> normalItem = normalItemRepository.findByIdOptional(id);
        return normalItem.isPresent()?
                normalItem.get():
                new NormalItem();
    }

    public AgedBrie cargaAgedBrie(long id) {
        Optional<AgedBrie> agedBrie = agedBrieRepository.findByIdOptional(id);
        return agedBrie.isPresent()?
                agedBrie.get():
                new AgedBrie();
    }
}
