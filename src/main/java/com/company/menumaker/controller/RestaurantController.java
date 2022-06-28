package com.company.menumaker.controller;

import com.company.menumaker.dto.CreateRequestRestaurant;
import com.company.menumaker.dto.RestaurantDto;
import com.company.menumaker.dto.UpdateRequestRestaurant;
import com.company.menumaker.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/menumarker/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){

        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Integer id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody CreateRequestRestaurant createRequestRestaurant) throws NameNotFoundException {
        return ResponseEntity.ok(restaurantService.createRestaurant(createRequestRestaurant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable Integer id,
                                                       @RequestBody UpdateRequestRestaurant updateRequestRestaurant) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, updateRequestRestaurant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantId(@PathVariable Integer id) {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.ok().build();
    }

}
