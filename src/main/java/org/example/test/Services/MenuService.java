package org.example.test.Services;

import lombok.AllArgsConstructor;
import org.example.test.Entities.Client;
import org.example.test.Entities.Composant;
import org.example.test.Entities.Menu;
import org.example.test.Repository.ClientRepository;
import org.example.test.Repository.ComposantRepository;
import org.example.test.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service //Définir que c'est un bean Spring
@AllArgsConstructor
public class MenuService implements IMenuService {
    MenuRepository menuRepository;
    ClientRepository clientRepository;
    ComposantRepository composantRepository;

    @Override
    public Menu add(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu find(long id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }

        public Menu ajouterComposantsEtMiseAJourPrixTotalMenu(Set<Composant> composants, Long idMenu){
            Menu menu = menuRepository.findById(idMenu).orElseThrow();

            if(menu.getPrixTotal()>=20) {
                return menu;
            }
            else {
                for (Composant com: composants) {
                    if (menu.getPrixTotal()+ com.getPrix()<20) {
                        menu.setPrixTotal(menu.getPrixTotal()+ com.getPrix());
                        com.setMenu(menu);
                        composantRepository.save(com);
                    }
                }
            }
            return menuRepository.save(menu);
        }

}
