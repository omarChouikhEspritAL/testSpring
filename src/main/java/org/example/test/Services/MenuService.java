package org.example.test.Services;

import lombok.AllArgsConstructor;
import org.example.test.Entities.Composant;
import org.example.test.Entities.Menu;
import org.example.test.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Définir que c'est un bean Spring
@AllArgsConstructor
public class MenuService implements IMenuService{
    MenuRepository menuRepository;
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
        return menuRepository.findById(id).orElse(Menu.builder().idMenu(0).build());
    }

    @Override
    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }

    public Menu ajoutComposantsEtMiseAJourPrixTotalMenu(List<Composant> composants, Long idMenu) {
        // Chercher le menu par son id
        Optional<Menu> existingMenu = menuRepository.findById(idMenu);
        if (existingMenu.isPresent()) {
            // Si le menu existe, ajouter les composants à sa liste de composants
            Menu updatedMenu = existingMenu.get();
            updatedMenu.getComposants().addAll(composants);
            // Calculer le nouveau prix total du menu en sommant les prix des composants
            float nouveauPrixTotal = 0.0f;
            for (Composant composant : updatedMenu.getComposants()) {
                nouveauPrixTotal += composant.getPrix();
            }
            // Mettre à jour le prix total du menu
            updatedMenu.setPrixTotal(nouveauPrixTotal);
            // Enregistrer le menu modifié dans la base de données
            return menuRepository.save(updatedMenu);
        } else {
            // Sinon, renvoyer null ou lancer une exception
            return null;
        }
    }

}
