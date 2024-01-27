package org.example.test.Services;

import lombok.AllArgsConstructor;
import org.example.test.Entities.Composant;
import org.example.test.Entities.Menu;
import org.example.test.Entities.Restaurant;
import org.example.test.Repository.MenuRepository;
import org.example.test.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service //Définir que c'est un bean Spring
@AllArgsConstructor
public class RestaurantService implements IRestaurantService{
    RestaurantRepository restaurantRepository;
    MenuRepository menuRepository;
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
    @Override
    public Restaurant ajouterRestaurantEtMenusAssocie(Restaurant restaurant) {
        restaurant.getMenuList().stream().forEach(menu -> menu.setPrixTotal(0));
            return restaurantRepository.save(restaurant);
    }


}
