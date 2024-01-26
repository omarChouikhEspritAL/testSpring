package org.example.test.Repository;

import org.example.test.Entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepository extends JpaRepository<Composant,Long> {
}
