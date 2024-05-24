package edu.badpals.repository;

import edu.badpals.domain.BackstagePass;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BackstagepassRepository implements PanacheRepository<BackstagePass> {
}
