package com.company.menumaker.controller;

import com.company.menumaker.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/restaurant/{id}")
    public String getRestaurantById(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("restaurant", service.getRestaurantById(id));
        return "restaurant";
    }

    @GetMapping()
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants", service.getAllRestaurants());
        return "restaurants";
    }
}
