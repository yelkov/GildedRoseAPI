package edu.badpals.repository;

import edu.badpals.domain.AgedBrie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgedBrieRepository implements PanacheRepository<AgedBrie> {
}
