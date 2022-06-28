package com.company.menumaker.repositories;

import com.company.menumaker.entities.Restaurant;
import com.company.menumaker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>, JpaSpecificationExecutor<Restaurant> {
    Optional<Restaurant> findByEmail(String  email);
    Optional<Restaurant> findByPhone(String  phone);
    Optional<Restaurant> findByName(String  name);
    Optional<Restaurant> findByState(Integer  state);
}