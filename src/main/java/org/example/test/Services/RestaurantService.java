package org.example.test.Services;

import lombok.AllArgsConstructor;
import org.example.test.Entities.Restaurant;
import org.example.test.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Définir que c'est un bean Spring
@AllArgsConstructor
public class RestaurantService implements IRestaurantService{
    RestaurantRepository restaurantRepository;
    @Override
    public Restaurant add(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant find(long id) {
        return restaurantRepository.findById(id).orElse(Restaurant.builder().idRestaurant(0).build());
    }

    @Override
    public void delete(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
    }

    public Restaurant ajouterRestaurantEtMenusAssocie(Restaurant restaurant) {
        // Vérifier si le restaurant existe déjà dans la base de données
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(restaurant.getIdRestaurant());
        if (existingRestaurant.isPresent()) {
            // Si le restaurant existe, mettre à jour ses menus
            Restaurant updatedRestaurant = existingRestaurant.get();
            updatedRestaurant.setMenuList(restaurant.getMenuList());
            return restaurantRepository.save(updatedRestaurant);
        } else {
            // Sinon, enregistrer le restaurant et ses menus
            return restaurantRepository.save(restaurant);
        }
    }

}
