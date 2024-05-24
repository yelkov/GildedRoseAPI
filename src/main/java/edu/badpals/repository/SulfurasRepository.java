package edu.badpals.repository;

import edu.badpals.domain.Sulfuras;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SulfurasRepository implements PanacheRepository<Sulfuras> {
}
