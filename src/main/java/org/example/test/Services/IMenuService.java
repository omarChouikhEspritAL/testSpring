package org.example.test.Services;

import org.example.test.Entities.Composant;
import org.example.test.Entities.Menu;

import java.util.List;
import java.util.Set;

public interface IMenuService {
    Menu add(Menu menu);

    Menu update(Menu menu);

    List<Menu> findAll();

    Menu find(long id);

    void delete(Menu menu);

    Menu ajouterComposantsEtMiseAJourPrixTotalMenu(Set<Composant> composants, Long idMenu);
}