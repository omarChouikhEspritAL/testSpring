package org.example.test.Services;

import org.example.test.Entities.Composant;
import org.example.test.Entities.Menu;

import java.util.List;

public interface IMenuService {
    Menu add(Menu menu);
    Menu update (Menu menu);
    List<Menu> findAll();
    Menu find(long id);
    void  delete(Menu menu);
    Menu ajoutComposantsEtMiseAJourPrixTotalMenu(List<Composant>, Menu menu);
}
