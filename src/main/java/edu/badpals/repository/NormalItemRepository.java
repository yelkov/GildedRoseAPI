package edu.badpals.repository;

import edu.badpals.domain.NormalItem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NormalItemRepository implements PanacheRepository<NormalItem> {
}
