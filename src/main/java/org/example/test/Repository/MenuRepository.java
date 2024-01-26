package org.example.test.Repository;

import org.example.test.Entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    Menu findByLibelleMenu(String libelleMenu);
}
