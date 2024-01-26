package org.example.test.RestControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.test.Entities.Menu;
import org.example.test.Entities.Restaurant;
import org.example.test.Services.IRestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Restaurant Management")
@RestController
@RequestMapping("/restaurant/")
@AllArgsConstructor
public class RestaurantRestController {
    IRestaurantService iRestaurantService;

    @Operation(description = "Retrieve all Restaurant")
    @GetMapping("getAll")
    public List<Restaurant> getAllRestaurant() {
        return iRestaurantService.findAll();
    }

    @PostMapping("add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return iRestaurantService.add(restaurant);
    }


    @GetMapping("getById")
    public Restaurant getById(@RequestParam long id) {
        return iRestaurantService.find(id);
    }

    @DeleteMapping("/delete")
    public void deleteRestaurant(@RequestBody Restaurant restaurant) {
        iRestaurantService.delete(restaurant);
    }

}
