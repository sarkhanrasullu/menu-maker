package com.company.menumaker.repository;

import com.company.menumaker.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>, JpaSpecificationExecutor<Restaurant> {
    Optional<Restaurant> findByEmail(String  email);
    Optional<Restaurant> findByPhone(String  phone);
    Optional<Restaurant> findByName(String  name);
    Optional<Restaurant> findByState(Integer  state);
}