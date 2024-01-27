package org.example.test.Services;

import org.example.test.Entities.Composant;
import org.example.test.Entities.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant add(Restaurant restaurant);
    Restaurant update (Restaurant restaurant);
    List<Restaurant> findAll();
    Restaurant find(long id);
    void  delete(Restaurant restaurant);
    Restaurant ajouterRestaurantEtMenusAssocie(Restaurant restaurant);
}
